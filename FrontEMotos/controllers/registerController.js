angular.module('app').controller('registerController', function ($scope, $http, $location) {
    $scope.addressClient = {}
    $scope.client = {}
    
    console.log("Entrando no register")

    $scope.saveClient = function() {
        console.log("registrando")
        $scope.client.addressUser = $scope.addressClient
        console.log($scope.client)

        if($scope.formRegister.$valid){
            $http.post("http://localhost:8080/user/createUser", $scope.client).then(function(response){
                if($scope.client != null && $scope.client != ''){
                    if($scope.client.addressUser != null && $scope.client.addressUser != ''){
                        $location.path("/view/")
                    }
                } 
            }, function(response){
                console.log(response)
            })
        }
    }
 
    $scope.goToLogin = function() {
        $location.path("/view/")
    }
})