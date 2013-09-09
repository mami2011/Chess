'use strict';

// Declare app level module which depends on filters, and services
var profileApp = angular.module('profileApp', ['errorResponseModule']);

profileApp.config(['$routeProvider', function($routeProvider) {
	
	// When there is something after the hashtag
	$routeProvider.when('/profile',		{templateUrl: 'profile/partial/account',	controller: 'ProfileCtrl'});
	$routeProvider.when('/email',		{templateUrl: 'profile/partial/email',		controller: 'ProfileCtrl'});
	$routeProvider.when('/password',	{templateUrl: 'profile/partial/password',	controller: 'ProfileCtrl'});
	
	// Otherwise when no hashtag or hashtag path can't be found, add a hashtag
	$routeProvider.otherwise({redirectTo: '/profile'});
}]);