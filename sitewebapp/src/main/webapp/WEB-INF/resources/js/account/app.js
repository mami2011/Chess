'use strict';

// Declare app level module which depends on filters, and services
var accountApp = angular.module('accountApp', []);

accountApp.config(['$routeProvider', function($routeProvider) {

	$routeProvider.when('/contact',			{templateUrl: 'partials/?n=contact', controller: 'AccountCtrl'});
	$routeProvider.when('/contact/:edit',	{templateUrl: 'partials/?n=contactEdit', controller: 'AccountCtrl'});
	$routeProvider.when('/email/:edit',		{templateUrl: 'partials/?n=emailEdit', controller: 'AccountCtrl'});
	$routeProvider.when('/password/:edit',	{templateUrl: 'partials/?n=passwordEdit', controller: 'AccountCtrl'});
	$routeProvider.otherwise({redirectTo: '/contact'});
}]);