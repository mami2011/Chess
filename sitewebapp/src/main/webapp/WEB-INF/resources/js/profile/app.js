'use strict';

// Declare app level module which depends on filters, and services
var profileApp = angular.module('profileApp', ['errorResponse']);

profileApp.config(['$routeProvider', function($routeProvider) {

	$routeProvider.when('/profile',		{templateUrl: 'profile/partial/account',	controller: 'ProfileCtrl'});
	$routeProvider.when('/email',		{templateUrl: 'profile/partial/email',		controller: 'ProfileCtrl'});
	$routeProvider.when('/password',	{templateUrl: 'profile/partial/password',	controller: 'ProfileCtrl'});
	
	$routeProvider.otherwise({redirectTo: '/profile'});
}]);