'use strict';


/*******************
Using the array notation requires the listing of
all the function params as strings in same order.
********************/
accountApp.controller('AccountCtrl', ['$scope', '$http', '$routeParams', '$location', 'Data', function($scope, $http, $routeParams, $location, Data) {
	
	$scope.page = Data;
	$scope.pageEdit = angular.copy($scope.page);

	/** Do something when param is 'edit'
	if ($routeParams.edit) {
		//$('#info').removeClass('readonly');
		
		// remove page messages
		$scope.$parent.success = false;
		$scope.$parent.error = false;
	}**/
	
	$scope.save = function() {
		
		$http.post('account/save', $scope.pageEdit).
			success(function (data, status, headers, config) {
				$scope.updateModel(data);
			}).
			error(function(data, status, headers, config) {
				
			});
		

	};
	
	$scope.updateModel = function(pageEdit) {

		// Update the model
		for(var key in pageEdit) {
	        if (pageEdit.hasOwnProperty(key)) {
	            $scope.page[key] = pageEdit[key];
	        }
	    }
	
		
		//alert("xxxx:" + pageEdit.fieldMap.ADDRESS_LINE_1.errors[0].message);
		
		/*
		// Check for field errors
		var hasFieldError = false;
		for (var key in pageEdit.fieldMap) {
			var field = pageEdit.fieldMap[key];
			if (field.errors) {
				//alert('there is an error');
			}
			else {
				//alert(field.errors);
			}
		}*/
		
		
		/*
		// Take user to contact info page if no errors
		if (!data.errors) {
			$location.path('account'); // path not hash
			
			// Show success message on contact info page
	    	$('.alert-success').show().delay(1500).fadeOut(300);
		}
		else {
			$('.alert-danger').show();
		}*/
  	};

	$scope.reset = function() {
    	$scope.pageEdit = angular.copy($scope.page);
    	$location.path('account'); // path not hash
  	};
  	
  	$scope.getClass = function(path) {
  		
  		//alert($location.path().substr(0, path.length));
  		if ($location.path() == path)  {
		//if ($location.path().substr(0, path.length) == path) {
			return 'curr';
		} else {
			return '';
		}
	};
  
}]);
	

