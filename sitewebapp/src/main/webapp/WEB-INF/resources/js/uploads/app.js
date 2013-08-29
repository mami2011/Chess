'use strict';

// Declare app level module which depends on filters, and services
var uploadsApp = angular.module('uploadsApp', ['errorResponse']);

uploadsApp.config(['$routeProvider', function($routeProvider) {

	$routeProvider.when('/uploads',		{templateUrl: 'uploads/partial/files',	controller: 'ProfileCtrl'});
	$routeProvider.when('/uploader',		{templateUrl: 'profile/partial/uploader',		controller: 'ProfileCtrl'});
	$routeProvider.when('/password',	{templateUrl: 'profile/partial/password',	controller: 'ProfileCtrl'});
	
	$routeProvider.otherwise({redirectTo: '/accounthub'});
}]);