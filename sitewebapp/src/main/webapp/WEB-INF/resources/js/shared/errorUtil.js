'use strict';

/***** Sample errorResponse model ***********
var errorResponse = {
	"fieldBindingErrors":[
		{
			"error":{
				"errorCode":{
					"type":"RegistrationErrorCode",
					"errorCode":"MISSING_FIRSTNAME"
				},
				"message":"First name is required",
				"severity":"ERROR",
				"domain":"REGISTRATION",
				"arguments":null
			},
			"bindingFieldMap":{
				"com.vendertool.sharedtypes.core.ContactDetails":["firstName"]
			}
		},
        {
            "error":{
               "errorCode":{
                  "type":"RegistrationErrorCode",
                  "errorCode":"MISSING_LASTNAME"
               },
               "message":"Last name is required",
               "severity":"ERROR",
               "domain":"REGISTRATION",
               "arguments":null
            },
            "bindingFieldMap":{
               "com.vendertool.sharedtypes.core.ContactDetails":["lastName"]
            }
         }
    ],
	"status":null,
	"emailId":null
};
**********************************/

var ErrorUtil = {
	
	getFieldErrors: function(className, fieldName, errorResponse) {
		var fldErrors = [], i, n, j, m;
		
		for (i=0, n=errorResponse.fieldBindingErrors.length; i<n; i++) {
			var fldError = errorResponse.fieldBindingErrors[i];
			var fields = fldError.bindingFieldMap[className];

			for (j=0, m=fields.length; j<m; j++) {
				if (fields[j] === fieldName) {
					fldErrors.push(fldError);
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


