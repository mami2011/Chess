'use strict';


/*******************
Using the array notation requires the listing of
all the function params as strings in same order.
********************/
uploadsApp.controller('UploadsCtrl', ['$scope', '$http', '$routeParams', '$location', function($scope, $http, $routeParams, $location) {
	
	

	window.$windowScope = $scope;
	
	
	$scope.updateFiles = function(files) {
		
		//alert(files[0] + 'xxx');
	};
	
	$scope.openPopup = function() {
		
		var left,
			top,
			width = 575,
			height = 325,
			props
		;
	
		wLeft = window.screenLeft ? window.screenLeft : window.screenX;
		wTop = window.screenTop ? window.screenTop : window.screenY;
		
		left = wLeft + (window.innerWidth/2) - (width/2);
		top = wTop + (window.innerHeight/2) - (height/2);
		
		// Prevent top of popup from being above parent window
		if (top < wTop) {
			top = wTop;
		}
		
		props = 'left=' + left + ',top=' + top + ',width=' + width + ',height=' + height + ',toolbar=0,location=0,status=0,menubar=0,resizable=1';
		window.open('../fileUploader', 'popup', props);
	};
	
	
	//alert('hello' + URL.uploadsUrl);
	
	/**
	$scope.accountOrig = Data.account;
	$scope.accountEdit = angular.copy(Data.account);
	$scope.errorResponse = Data.errorResponse;
	$scope.countryOptions = Data.countryOptions;
	$scope.changeEmailRequest = {};
	$scope.changePasswordRequest = {};
	**/
	/** Do something when param is 'edit'**/
	//if ($routeParams.edit) {
		//$('#info').removeClass('readonly');
		
		// remove page messages
		//$scope.$parent.success = false;
		//$scope.$parent.error = false;
		
		//$('.alert-success').hide();
		//$('.alert-danger').hide();
	//}
	
	/** Do something when page is 'email'**/


}]);






