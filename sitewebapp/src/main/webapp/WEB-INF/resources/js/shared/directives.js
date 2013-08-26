'use strict';


profileApp.directive("myFirstDirective", function() {
	
	
		
	  return function(scope, element, attrs) {
		  
		  alert('hello ' + scope.accountOrig.emailId);
		 
		  alert(attrs.fieldName);
	  };
});
