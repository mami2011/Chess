'use strict';


/*******************
Using the array notation requires the listing of
all the function params as strings in same order.
********************/
profileApp.controller('ProfileCtrl', ['$scope', '$http', '$routeParams', '$location', 'Data', function($scope, $http, $routeParams, $location, Data) {
	
	$scope.accountOrig = angular.copy(Data.account);
	$scope.accountEdit = angular.copy(Data.account);
	$scope.errorResponse = angular.copy(Data.errorResponse);
	

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
				
				$scope.accountOrig = angular.copy(data.account);
				$scope.accountEdit = angular.copy(data.account);
				$scope.errorResponse = angular.copy(data.errorResponse);
				
				
				if ($scope.errorResponse.fieldBindingErrors.length > 0) {
					// Show error message at the top of page
					$('.alert-danger').show();
					
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

				}
				else {
					$scope.errorMap = null;
					
					// Take user to profile page
					//$location.path('/profile'); // path not hash
					$('.alert-danger').hide();
					$('.alert-success').show().delay(1500).fadeOut(300);
				}
				
				
			}).
			error(function(data, status, headers, config) {
				
			});
		

	};
	
	
	$scope.updateModel = function(data) {
		
		var hasChanged = false, key;
		
		$scope.account = angular.copy(data.account);
    	
		alert($scope.account.contactDetails.address.addressLine1);
		
		//$scope.errorResponse = data.errorResponse;
		
		/*
		//if (data.errorResponse) {
			// Show error message at the top of page
		//	$('.alert-danger').show();
		//}
		//else {
			// Update the account model
			for (key in data.account) {
				
				
				if (data.account.hasOwnProperty(key)) {

					// Only flip flag if not already flipped
					if ($scope.account[key] !== data.account[key] && hasChanged === false) {
						hasChanged = true;
					}

					// Do the update
					$scope.account[key] = data[key];
					$scope.accountEdit[key] = data[key];
					

				}
				
			}
			
			

			// Show success message on contact info page
			$location.path('/profile'); // path not hash
			
			if (hasChanged) {
				$('.alert-success').show().delay(1500).fadeOut(300);
			}
			
		//}*/
  	};
  	
  	

	$scope.reset = function() {
    	$scope.accountEdit = angular.copy($scope.accountOrig);
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
	

