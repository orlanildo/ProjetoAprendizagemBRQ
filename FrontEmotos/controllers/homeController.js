
angular.module('app').controller('homeController', function ($scope, $http, $location) {
    
    // isso é um thw wai databind basta prenchelo 
    // com os dados da api que será refletido ba tela 
    $scope.moto = []



    $scope.goToLogin = function () {
        $location.path("/view/")
    }

    $scope.goToPayment = function () {
        console.log("goToPayment")
        $location.path("/view/payment")
    }
    
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