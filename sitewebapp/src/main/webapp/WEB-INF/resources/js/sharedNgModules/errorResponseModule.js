
/**
 * Needs the scope.errorResponse to be defined in the controller.
 * scope.errorResponse the json model of com.vendertool.sharedtypes.rnr.ErrorResponse.
 */
angular.module('errorResponseModule', []).directive("errorResponse", function() {
	'use strict';

	return {
		link: function(scope, element, attrs) {
			
			var getErrorMsgs = function() {
				scope.errorMsgs = ErrorUtil.getErrorMsgs(attrs.clss, attrs.field, scope.errorResponse);

				var wrap = element.closest('.fldWrp');
				
				if (scope.errorMsgs.length > 0) {
					// Add error style to fieldWrapper
					if (wrap) {
						wrap.addClass('err');
					}
				}
				else {
					// Remove error style to fieldWrapper
					if (wrap) {
						wrap.removeClass('err');
					}
				}
		    };
		    
			// If $scope.errorResponse in main app changes then run getErrorMsgs()
		    scope.$watch("errorResponse", getErrorMsgs);
		},
		scope: true,
		replace: true,
		template:'<div><div class="err-msg" ng-repeat="errorMsg in errorMsgs">{{errorMsg}}</div></div>'
		
	};
});



var ErrorUtil = {
		
	getFieldErrors: function(className, fieldName, errorResponse) {
		var fldErrors = [], i, n, j, m;
		
		if (errorResponse && errorResponse.fieldBindingErrors) {
			for (i=0, n=errorResponse.fieldBindingErrors.length; i<n; i++) {
				var fldError = errorResponse.fieldBindingErrors[i];
				var fields = fldError.bindingFieldMap[className];
				
				if (fields) {
					for (j=0, m=fields.length; j<m; j++) {
						if (fields[j] === fieldName) {
							fldErrors.push(fldError);
						}
					}
				}
			}
		}

		return fldErrors;
	},
	
	getErrorMsgs: function(className, fieldName, errorResponse) {
		var i, j, fldErrors, errorMsgs = [];
		
		fldErrors = ErrorUtil.getFieldErrors(className, fieldName, errorResponse);
		for (i=0, j=fldErrors.length; i<j; i++) {
			errorMsgs.push(fldErrors[i].error.message);
		}
		
		return errorMsgs;
	},
	
	getErrorMap: function(className, fieldNames, errorResponse) {
		var i, j, fldName, fldErrors, errorMap = {};
		
		for (i=0, j=fieldNames.length; i<j; i++) {
			fldName =  fieldNames[i];
			fldErrors = ErrorUtil.getErrorMsgs(className, fldName, errorResponse);
			if (fldErrors.length > 0) {
				errorMap[fldName] = fldErrors;
			}
		}
		
		return errorMap;
	}
};