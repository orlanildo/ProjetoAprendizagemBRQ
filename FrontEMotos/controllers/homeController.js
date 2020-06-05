angular.module('app').controller('homeController', function ($scope, $http, $location, $rootScope) {
    
    // isso é um thw wai databind basta prenchelo 
    // com os dados da api que será refletido ba tela 
    $scope.user = $rootScope.user;
    $scope.motos = []
    $scope.moto = {}
    $scope.filtro = '';


    $scope.goToLogin = function () {
        $location.path("/view/")
    }

    $scope.goToPayment = function (moto) {
        console.log("goToPayment" + moto)
        $rootScope.selectedMoto = moto;
        $location.path("/view/payment")
    }

    $scope.esconderMoto = function(motoRent){
        if(motoRent == 'rent'){
            return true;
        }
        else{
            return false;
        }
    }

    $scope.userRented = function(userRent){
        if(userRent == 'rented'){
            return true;
        }
        else{
            return false;
        }
    }

    $scope.userClient = function(userType){
        if(userType == 'client'){
            return true;
        }
        else{
            return false;
        }
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
    })
    .catch( function(erro){
        console.log(erro);
    })
 
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