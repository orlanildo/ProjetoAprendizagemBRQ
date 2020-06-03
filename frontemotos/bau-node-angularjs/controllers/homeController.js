
angular.module('app').controller('homeController', function ($scope, $http, $location, $rootScope) {
    
    // isso é um thw wai databind basta prenchelo 
    // com os dados da api que será refletido ba tela 
    $scope.motos = []


    $scope.goToLogin = function () {
        $location.path("/view/")
    }

    $scope.goToPayment = function (id) {
        console.log("goToPayment" + id)
        $rootScope.idMoto = id;
        $location.path("/view/payment")
    }

    $scope.sair = function () {
    	console.log("Saindo")
    	$http.get('http://localhost:8080/sair').then(function (res) {
            console.log(res)
            
            $location.path("/view/")
         })
    }
    
    
    $http.get('http://localhost:8080/moto/listMotos').then(function (res) {
        $scope.motos = res.data;
        console.log($scope.motos)
    })
    .catch( function(erro){
        console.log(erro);
    })

    /*$http.get('http://localhost:8080/moto/listMotos')
    .success( function(motos){
        $scope.motos = motos;
    })
    .error( function(erro) {
        console.log(erro);
    })*/


    

    // $scope.createMoto = function () {
    //     $http.post('/client').then(function (res) {
    //         console.log(res.data)
    //         console.log(res.status)
    //     }, function (res) {
    //         console.log(res.data)
    //         console.log(res.status)
    //     })
    // }

    // $scope.updateMoto = function () {
    //     $http.post('/client/id').then(function (res) {
    //         console.log(res.data)
    //         console.log(res.status)
    //     }, function (res) {
    //         console.log(res.data)
    //         console.log(res.status)
    //     })
    // }

    // $scope.deleteMoto = function () {
    //     $http.post('/client/id').then(function (res) {
    //         console.log(res.data)
    //         console.log(res.status)
    //     }, function (res) {
    //         console.log(res.data)
    //         console.log(res.status)
    //     })
    // }

})