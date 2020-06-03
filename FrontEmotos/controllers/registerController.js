
angular.module('app').controller('registerController', function ($scope, $http, $location) {
    $scope.addressClient = {}
    $scope.client = {}

    $scope.saveClient = function() {
        $scope.client.addressUser = $scope.addressClient
        
    	$http.post("http://localhost:8080/user/createUser", $scope.client).then(function(response){
    	 	console.log(response)
             $location.path("/view/login")
    	}, function(response){
    	 	console.log(response)
    	})
    }

    $scope.goToLogin = function() {
        $location.path("/view/")
    }
})


