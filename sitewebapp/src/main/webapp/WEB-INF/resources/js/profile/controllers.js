'use strict';


/*******************
Using the array notation requires the listing of
all the function params as strings in same order.
********************/
profileApp.controller('ProfileCtrl', ['$scope', '$http', '$routeParams', '$location', 'Data', function($scope, $http, $routeParams, $location, Data) {
	
	$scope.accountOrig = Data.account;
	$scope.accountEdit = angular.copy(Data.account);
	$scope.errorResponse = Data.errorResponse;
	$scope.countryOptions = Data.countryOptions;
	$scope.changeEmailRequest = {};


	/** Do something when param is 'edit'**/
	//if ($routeParams.edit) {
		//$('#info').removeClass('readonly');
		
		// remove page messages
		//$scope.$parent.success = false;
		//$scope.$parent.error = false;
		
		//$('.alert-success').hide();
		//$('.alert-danger').hide();
	//}
	
	/** Do something when page is 'email'**/
	if ($location.path() === '/email') {

		$http.get('profile/email').success(function(data) {
			$scope.changeEmailRequest = data.changeEmailRequest;
		});
	}
	
	$scope.saveAccount = function() {
		
		$http.post('profile/save', $scope.accountEdit).
			success(function (data, status, headers, config) {

				$scope.accountEdit = data.account;
				$scope.errorResponse = data.errorResponse;
				
				if ($scope.errorResponse.fieldBindingErrors.length > 0) {
					showPageErrorMsg();
				}
				else {
					// Only update this if no errors
					$scope.accountOrig = data.account;
					$scope.errorResponse = undefined;
					
					// Take user to profile page
					//$location.path('/profile'); // path not hash
					showPageSuccessMsg('profile');
				}
			}).
			error(function(data, status, headers, config) {
				
			});
	};

	$scope.resetAccount = function() {
    	$scope.accountEdit = angular.copy($scope.accountOrig);
    	$scope.errorResponse = undefined;
    	$('.alert-danger').hide();
    	
    	/** TODO: Should we change path to make another request to get the account values from server?? **/
    	//$location.path('/'); // path not hash
  	};

	$scope.saveEmail = function() {
		
		$http.post('profile/email/save', $scope.changeEmailRequest).
			success(function (data, status, headers, config) {
				
				$scope.changeEmailRequest = data.changeEmailRequest;
				$scope.errorResponse = data.errorResponse;

				if ($scope.errorResponse.fieldBindingErrors.length > 0) {
					// Show error message at the top of page
					showPageErrorMsg();
				}
				else {
					// Only update this if no errors
					$scope.changeEmailRequest.oldEmailId = data.changeEmailRequest.newEmail;
					$scope.changeEmailRequest.newEmail = '';
					$scope.changeEmailRequest.confirmEmail = '';
					$scope.errorResponse = undefined;

					showPageSuccessMsg('email');
				}
			}).
			error(function(data, status, headers, config) {
				
			});
	};
	
	$scope.resetEmail = function() { 
    	$scope.changeEmailRequest.newEmail = '';
    	$scope.changeEmailRequest.confirmEmail = '';
    	$scope.errorResponse = undefined;
    	$('.alert-danger').hide();
  	};
  	
  	$scope.savePassword = function() {
		
		$http.post('profile/password/save', $scope.changePasswordRequest).
			success(function (data, status, headers, config) {
				
				$scope.changePasswordRequest = data.changePasswordRequest;
				$scope.errorResponse = data.errorResponse;

				if ($scope.errorResponse.fieldBindingErrors.length > 0) {
					// Show error message at the top of page
					showPageErrorMsg();
				}
				else {
					// Only update this if no errors
					$scope.changePasswordRequest.newPassword = '';
					$scope.changePasswordRequest.confirmPassword = '';
					$scope.errorResponse = undefined;

					showPageSuccessMsg('password');
				}
			}).
			error(function(data, status, headers, config) {
				
			});
	};
	
	$scope.resetPassword = function() { 
    	$scope.changePasswordRequest.newPassword = '';
    	$scope.changePasswordRequest.confirmPassword = '';
    	$scope.errorResponse = undefined;
    	$('.alert-danger').hide();
  	};
  	
  	
  	
  	
  	/** Gets CSS 'curr' class to style current item in leftNav menu **/
  	$scope.getClass = function(path) {
  		
  		//alert($location.path().substr(0, path.length));
  		if ($location.path() == path)  {
		//if ($location.path().substr(0, path.length) == path) {
			return 'curr';
		} else {
			return '';
		}
	};
	
  	var showPageErrorMsg = function() {
  		$('.alert-success').hide();
  		$('.alert-danger').show();
  	};
  	
	var showPageSuccessMsg = function(type) {
		$('.alert-danger').hide();
		if (type === 'profile') {
			$('.alert-success.profile').show().delay(1500).fadeOut(300);
		}
		else if (type === 'email') {
			$('.alert-success.email').show().delay(1500).fadeOut(300);
		}
		else if (type === 'password') {
			$('.alert-success.password').show().delay(1500).fadeOut(300);
		}
  	};

}]);




