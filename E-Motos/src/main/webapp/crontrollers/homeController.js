angular.module('app').controller('homeController', function ($scope, $http) {
    $scope.moto = []

    console.log('Entrou no controle de home')

    $scope.goToLogin = function () {
        window.location.href = "/login"
    }
    
    $http.get('http://localhost:8080/moto/listMotos').then(function (res) {
        $scope.motos = res.data;
        console.log($scope.motos);
    })
    .catch( function(erro){
        console.log(erro);
    })
    
    $scope.listMotos = function () {
    	console.log("listMotos")
    	$http.get('/moto/listMotos').then(function (res) {
             console.log(res.data)
             console.log(res.status)
             $scope.moto.push(angular.copy(res.data))
             
             console.log($scope.moto)
             return res.data
         })
    }

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