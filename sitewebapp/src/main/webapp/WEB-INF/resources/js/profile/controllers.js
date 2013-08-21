'use strict';


/*******************
Using the array notation requires the listing of
all the function params as strings in same order.
********************/
profileApp.controller('ProfileCtrl', ['$scope', '$http', '$routeParams', '$location', 'Data', function($scope, $http, $routeParams, $location, Data) {
	
	$scope.profile = Data;
	$scope.profileEdit = angular.copy($scope.profile);

	/** Do something when param is 'edit'**/
	//if ($routeParams.edit) {
		//$('#info').removeClass('readonly');
		
		// remove page messages
		//$scope.$parent.success = false;
		//$scope.$parent.error = false;
		
		//$('.alert-success').hide();
		//$('.alert-danger').hide();
		
	//}
	

	
	$scope.save = function() {
		
		$http.post('profile/save', $scope.profileEdit).
			success(function (data, status, headers, config) {
				
				//alert(data.error.NULL_ARGUMENT_PASSED.errorMessage);
				
				
				$scope.updateModel(data);
			}).
			error(function(data, status, headers, config) {
				
			});
		

	};
	
	$scope.updateModel = function(profileEdit) {

		// Update the model
		for(var key in profileEdit) {
	        if (profileEdit.hasOwnProperty(key)) {
	            $scope.profile[key] = profileEdit[key];
	        }
	    }
	
		
		//alert("xxxx:" + pageEdit.fieldMap.ADDRESS_LINE_1.errors[0].message);
		

		/*
		
		if (hasFieldError) {
			$('.alert-danger').show();
		}
		else {
			// Show success message on contact info page
			$location.path('profile'); // path not hash
	    	$('.alert-success').show().delay(1500).fadeOut(300);
		}*/
  	};

	$scope.reset = function() {
    	$scope.pageEdit = angular.copy($scope.page);
    	$location.path('profile'); // path not hash
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
	

