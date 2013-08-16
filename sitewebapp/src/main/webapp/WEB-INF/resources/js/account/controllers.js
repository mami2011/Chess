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
	
	

	
	$scope.reset = function() {
    	$scope.editAccount = angular.copy($scope.account);
    	$location.path('account'); // path not hash
  	};
  
}]);
	

