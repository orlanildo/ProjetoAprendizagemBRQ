
angular.module('app').controller('registerController', function ($scope, $http, $location) {
    $scope.client = {}

    $scope.goToHome = function() {
    	console.log($scope.client)
        
    	$http.post("http://localhost:8080/user/createUser", $scope.client).then(function(response){
    	 	console.log(response)
    	}, function(response){
    	 	console.log(response)
    	})
    	
        $location.path("/view/home")
    }

    $scope.goToLogin = function() {
        console.log('goToLogin')
        $location.path("/view/")
    }
})


