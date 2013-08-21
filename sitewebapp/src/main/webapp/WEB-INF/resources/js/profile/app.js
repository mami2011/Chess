'use strict';

// Declare app level module which depends on filters, and services
var profileApp = angular.module('profileApp', []);

profileApp.config(['$routeProvider', function($routeProvider) {

	$routeProvider.when('/profile',			{templateUrl: 'profile/partial/profile', controller: 'ProfileCtrl'});
	$routeProvider.when('/profile/:edit',	{templateUrl: 'profile/partial/profileEdit', controller: 'ProfileCtrl'});
	$routeProvider.when('/email/:edit',		{templateUrl: 'partials/?n=emailEdit', controller: 'ProfileCtrl'});
	$routeProvider.when('/password/:edit',	{templateUrl: 'partials/?n=passwordEdit', controller: 'ProfileCtrl'});
	$routeProvider.otherwise({redirectTo: '/profile'});
}]);