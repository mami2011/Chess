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
	
	if ($location.path() === '/profile') {
		// If user goes back to main profile page,
		// clear errors if any.
		$scope.profile.error = null;
	}
	

	
	$scope.save = function() {
		
		$http.post('profile/save', $scope.profileEdit).
			success(function (data, status, headers, config) {

				//alert(data.error.NULL_ARGUMENT_PASSED.errorMessage);
				
				// If errors, only the error object is updated.
				$scope.updateModel(data);
			}).
			error(function(data, status, headers, config) {
				
			});
		

	};
	
	$scope.updateModel = function(profileEdit) {
		
		if (profileEdit.error) {
			// Only update the error object
			$scope.profile.error = profileEdit.error;
			 
			// Show error message at the top of page
			$('.alert-danger').show();
		}
		else {
			// Update the entire model
			for(var key in profileEdit) {
		        if (profileEdit.hasOwnProperty(key)) {
		            $scope.profile[key] = profileEdit[key];
		        }
		    }
			
			// Show success message on contact info page
			$location.path('/profile'); // path not hash
			$('.alert-success').show().delay(1500).fadeOut(300);
		}
  	};
  	
  	

	$scope.reset = function() {
    	$scope.profileEdit = angular.copy($scope.profile);
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
	

