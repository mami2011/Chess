

/*******************
Using the array notation requires the listing of
all the function params as strings in same order.
********************/
securityQuestionsApp.controller('SecurityQuestionsCtrl', ['$scope', '$http', '$location', 'Data', function($scope, $http, $location, Data) {
	
	var removeOption;
	
	$scope.question1;
	$scope.question2;
	$scope.question1Options = angular.copy(Data.questions);
	$scope.question2Options = angular.copy(Data.questions);
	$scope.answer1;
	$scope.answer2;
	
	//
	// Need to watch the questions, because we don't want users
	// selecting the same question more than once. When user selects
	// a question we need to remove that question from the other
	// list of options.
	//
	$scope.$watch("question1", function() {
		if ($scope.question1) {
			$scope.question2Options = removeOption($scope.question1, $scope.question2Options);
		}
	});

	$scope.$watch("question2", function() {
		if ($scope.question2) {
			 $scope.question1Options = removeOption($scope.question2, $scope.question1Options);
		}
	});
	
	$scope.save = function() {
		
		var questionsResp = {};
		
		questionsResp.questionAnswers = [{"questionId":$scope.question1, "answer":$scope.answer1}, {"questionId":$scope.question2, "answer":$scope.answer2}];
		
		console.log($scope.question1 + ":" + $scope.question2);
		
		$http.post('questions/save', questionsResp).
			success(function (data, status, headers, config) {
				
				//alert('all good');
				
				$location.path('accounthub'); 
				
				//$scope.$apply(function() { });
				
				/**
				$scope.accountEdit = data.account;
				$scope.errorResponse = data.errorResponse;
				
				if ($scope.errorResponse.fieldBindingErrors.length > 0) {
					showPageErrorMsg();
				}
				else {
					// Only update this if no errors
					$scope.accountOrig = data.account;
					$scope.errorResponse = undefined;
					
					// Take user to profile page
					//$location.path('/profile'); // path not hash
					showPageSuccessMsg('profile');
				}**/
			}).
			error(function(data, status, headers, config) {
				
				alert('error');
			});
	};
	
	removeOption = function(questionId, questions) {
		// Start with full original list
		questions = angular.copy(Data.questions);
		
		for (var i=0, n=questions.length; i<n; i++) {
			if (questionId === questions[i].id) {
				questions.splice(i, 1);
				return questions;
			}
		}
	};
	
	
	
	
}]);