'use strict';


/*******************
Using the array notation requires the listing of
all the function params as strings in same order.
********************/
accountApp.controller('AccountCtrl', ['$scope', '$http', '$routeParams', '$location', 'Data', function($scope, $http, $routeParams, $location, Data) {
	
	$scope.acctFieldSet = Data;
	$scope.acctFieldSetEdit = angular.copy($scope.acctFieldSet);
	
	/** Do something when param is 'edit'
	if ($routeParams.edit) {
		$('#info').removeClass('readonly');
	}**/
	
	$scope.save = function() {
		
		//alert($scope.acctFieldSetEdit.email.value);
		
		//$http.post('profile/save', {"email":{"name":"email", "value":"opopo", "errors":["err1","err2"]}})
		//$http.post('profile/save', {"email":{"name":"email", "value":"opopo", "errors":["err1", "err2"]}})
		$http.post('account/save', $scope.acctFieldSetEdit).
			success(function (errors) {
				
				
				$scope.updateModel();
				//$scope.acctFieldSet = $scope.acctFieldSetEdit;
				
				//$scope.acctFieldSet.addressLine1 = $scope.acctFieldSetEdit.addressLine1;
				
				//$scope.acctFieldSet = $scope.acctFieldSetEdit;
				
				//acctFieldSet = angular.copy($scope.acctFieldSetEdit);
				
				//acctFieldSet.addressLine1.value = "xxxxxxx";
				
				//alert('xx' + $scope.acctFieldSet.addressLine1.value);
			});
		
		
		//$scope.acctFieldSet = angular.copy(acctFieldSet);
	};
	
	$scope.updateModel = function() {
		
		for(var key in $scope.acctFieldSetEdit) {
	        if ($scope.acctFieldSetEdit.hasOwnProperty(key)) {
	            $scope.acctFieldSet[key] = $scope.acctFieldSetEdit[key];
	        }
	    }
		//$scope.acctFieldSet.addressLine1 = angular.copy(acctFieldSetEdit.addressLine1);
		
    	//$scope.acctFieldSet = angular.copy(acctFieldSetEdit);
    	$location.path('account'); // path not hash
  	};

	$scope.reset = function() {
    	$scope.acctFieldSetEdit = angular.copy($scope.acctFieldSet);
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
	

