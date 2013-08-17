'use strict';


/*******************
Using the array notation requires the listing of
all the function params as strings in same order.
********************/
accountApp.controller('AccountCtrl', ['$scope', '$http', '$routeParams', '$location', 'Data', function($scope, $http, $routeParams, $location, Data) {
	
	$scope.account = Data;
	$scope.editAccount = angular.copy($scope.account);
	
	/** Do something when param is 'edit'
	if ($routeParams.edit) {
		$('#info').removeClass('readonly');
	}**/
	
	$scope.save = function() {
		
		//alert(JSON.stringify($scope.fieldMap));
		
		//$http.post('profile/save', {"email":{"name":"email", "value":"opopo", "errors":["err1","err2"]}})
		//$http.post('profile/save', {"email":{"name":"email", "value":"opopo", "errors":["err1", "err2"]}})
		$http.post('account/save', $scope.account).
			success(function (account) {
				$scope.account = account;
			});
		
	};

	$scope.reset = function() {
    	$scope.editAccount = angular.copy($scope.account);
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
	

