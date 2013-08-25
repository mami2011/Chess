'use strict';


/*******************
Using the array notation requires the listing of
all the function params as strings in same order.
********************/
profileApp.controller('ProfileCtrl', ['$scope', '$http', '$routeParams', '$location', 'Data', function($scope, $http, $routeParams, $location, Data) {
	
	$scope.account = Data.account;
	$scope.accountEdit = angular.copy($scope.account);
	
	
	

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
		$('.alert-danger').hide();
	}
	

	
	$scope.save = function() {
		
		$http.post('profile/save', $scope.accountEdit).
			success(function (data, status, headers, config) {

				//alert(data.error.NULL_ARGUMENT_PASSED.errorMessage);
				
				$scope.updateModel(data);
			}).
			error(function(data, status, headers, config) {
				
			});
		

	};
	
	$scope.updateModel = function(data) {
		
		var hasChanged = false, key;
		
		$scope.accountEdit = data;
		
		if (data.error) {
			// Show error message at the top of page
			$('.alert-danger').show();
		}
		else {
			// Update the profile model
			for (key in data) {
				
				if (key !== 'error') {
					if (data.hasOwnProperty(key)) {

						// Only flip flag if not already flipped
						if ($scope.account[key] !== data[key] && hasChanged === false) {
							hasChanged = true;
						}

						// Do the update
						$scope.account[key] = data[key];
					}
				}
			}

			// Show success message on contact info page
			$location.path('/profile'); // path not hash
			
			if (hasChanged) {
				$('.alert-success').show().delay(1500).fadeOut(300);
			}
			
		}
  	};
  	
  	

	$scope.reset = function() {
    	$scope.accountEdit = angular.copy($scope.account);
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
	

