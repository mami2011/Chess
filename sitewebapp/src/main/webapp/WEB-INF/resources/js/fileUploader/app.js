'use strict';

// Declare app level module which depends on filters, and services
var fileUploaderApp = angular.module('fileUploaderApp', ['fileUploaderModule']);

fileUploaderApp.config(['$routeProvider', function($routeProvider) {
	
	// When there is something after the hashtag
	$routeProvider.when('/files',		{templateUrl: 'uploads/partial/files',		controller: 'UploadsCtrl'});
	
	// Otherwise when no hashtag or hashtag path can't be found, add a hashtag
	$routeProvider.otherwise({redirectTo: '/files'});
}]);