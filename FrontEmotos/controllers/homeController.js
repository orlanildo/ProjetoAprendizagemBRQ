
angular.module('app').controller('homeController', function ($scope, $http, $location, $rootScope) {
    
    $scope.motos = []

    $scope.goToLogin = function () {
        $location.path("/view/")
    }

    $scope.goToPayment = function (moto) {
        console.log("goToPayment moto")
        console.log(moto)
        $rootScope.selectedMoto = moto;
        $location.path("/view/payment")
    }

    $scope.sair = function () {
    	console.log("Saindo")
    	//$http.get('http://localhost:8080/sair').then(function (res) {

        $location.path("/view/")
         //})
    }
    
    $http.get('http://localhost:8080/moto/listMotos').then(function (res) {
        $scope.motos = res.data;
        console.log($scope.motos)
    })
    .catch( function(erro){
        console.log(erro);
    })
})