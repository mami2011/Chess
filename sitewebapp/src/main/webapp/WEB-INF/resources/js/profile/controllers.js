'use strict';


/*******************
Using the array notation requires the listing of
all the function params as strings in same order.
********************/
profileApp.controller('ProfileCtrl', ['$scope', '$http', '$routeParams', '$location', 'Data', function($scope, $http, $routeParams, $location, Data) {
	
	$scope.accountOrig = angular.copy(Data.account);
	$scope.accountEdit = angular.copy(Data.account);
	$scope.errorResponse = angular.copy(Data.errorResponse);
	$scope.countryOptions = angular.copy(Data.countryOptions);
	
	/** Do something when param is 'edit'**/
	//if ($routeParams.edit) {
		//$('#info').removeClass('readonly');
		
		// remove page messages
		//$scope.$parent.success = false;
		//$scope.$parent.error = false;
		
		//$('.alert-success').hide();
		//$('.alert-danger').hide();
		
	//}
	
	/** Do something when page is 'profile'**/
	if ($location.path() === '/profile') {
		//$('.alert-danger').hide();
	}

	
	$scope.save = function() {
		
		$http.post('profile/save', $scope.accountEdit).
			success(function (data, status, headers, config) {

				$scope.accountEdit = angular.copy(data.account);
				$scope.errorResponse = angular.copy(data.errorResponse);

				if ($scope.errorResponse.fieldBindingErrors.length > 0) {
					// Show error message at the top of page
					$('.alert-danger').show();
					
					/***
					var className = 'com.vendertool.sharedtypes.core.ContactDetails';
					var fieldNames = [
						'firstName',
						'lastName',
						'addressLine1',
						'addressLine2',
						'city',
						'state',
						'zip',
						'country'
					];
					
					$scope.errorMap = ErrorUtil.getErrorMap(className, fieldNames, $scope.errorResponse);
					**/
				}
				else {
					//$scope.errorMap = null;
					
					// Only update this if no errors
					$scope.accountOrig = angular.copy(data.account);

					$scope.errorResponse = undefined;
					
					// Take user to profile page
					//$location.path('/profile'); // path not hash
					$('.alert-danger').hide();
					$('.alert-success').show().delay(1500).fadeOut(300);
				}
				
				
			}).
			error(function(data, status, headers, config) {
				
			});
		

	};

	$scope.reset = function() {
    	$scope.accountEdit = angular.copy($scope.accountOrig);
    	$scope.errorResponse = undefined;
    	$('.alert-danger').hide();
    	
    	
    	/** TODO: Should we change path to make another request to get the account values from server?? **/
    	//$location.path('/'); // path not hash
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
	

