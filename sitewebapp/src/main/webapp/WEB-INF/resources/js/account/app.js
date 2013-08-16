'use strict';

// Declare app level module which depends on filters, and services
var accountApp = angular.module('accountApp', []);

accountApp.config(['$routeProvider', function($routeProvider) {

	$routeProvider.when('/contact', {templateUrl: 'partials/?n=contact', controller: 'AccountCtrl'});
	$routeProvider.when('/contact/:edit', {templateUrl: 'partials/?n=contact-edit', controller: 'AccountCtrl'});
	$routeProvider.otherwise({redirectTo: '/contact'});
}]);