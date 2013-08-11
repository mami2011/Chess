
var APP = angular.module('APP', []);

function ProfileCtrl($scope, $http, Data) {
    
	$scope.fieldMap = Data;
    
	$scope.saveProfile = function() {
		$http.post('profile/save', $scope.fieldMap)
		.success(function (fieldMap) {
			

			
			$scope.fieldMap = fieldMap;
        });
		
	};
		  
	$scope.showProfileForm = function() {
		alert('sdfjlkj');
	};
}


APP.directive('editProfile', function() {
	return function(scope, el, attrs) {
		
		el.bind('click', function() {
			$('#edit-info').show();
			$('#edit-info').animate({left: "0"}, 300);
			
		});
	};
});

APP.directive('editEmail', function() {
	return function(scope, el, attrs) {
		
		el.bind('click', function() {
			$('#edit-email').show();
			$('#edit-email').animate({left: "0"}, 300);
			
		});
	};
});
