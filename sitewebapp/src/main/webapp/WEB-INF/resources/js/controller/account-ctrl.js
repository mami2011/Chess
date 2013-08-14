
var module = angular.module('APP', []);

function AccountCtrl($scope, $http, Data) {

	$scope.account = Data;

	
	$scope.saveContactDetails = function() {
		
		$http.post('account/save', $scope.account)
			.success (function (account) {
				$scope.account = account;
			}
		);
		
	};
	
	$scope.$on(
	   "$routeChangeSuccess",
	   function($currentRoute, $previousRoute){
	        // Update the rendering.
	        //render();
		   
		   alert($currentRoute.route);
		   
		   if ($currentRoute == '/edit') {
			   alert('it edit');
		   }
		  
	    }
	);
	
	/*
	$scope.showAccountForm = function() {
		alert('sdfjlkj');
	};*/
}

module.config([
	'$routeProvider', 
	function($routeProvider) {
		$routeProvider.
			when('/edit', {
				templateUrl: 'partials/contact-edit.html',   
				controller: AccountCtrl
			});
	}
]);


module.directive('editContactDetails', function() {
	return function(scope, el, attrs) {
		
		el.bind('click', function() {
			$('#edit-info').show();
			$('#edit-info').animate({left: "0"}, 300);
			
		});
	};
});

module.directive('editEmail', function() {
	return function(scope, el, attrs) {
		
		el.bind('click', function() {
			$('#edit-email').show();
			$('#edit-email').animate({left: "0"}, 300);
			
		});
	};
});
