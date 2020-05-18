

app.controller('homeController', function ($scope, $http) {
    $scope.moto = {}

    console.log('Entrou no controle de home')

    $scope.goToLogin = function () {
        window.location.href = "/login"
    }

    
    // $scope.listMotos = function () {
    //     $http.get('/client').then(function (res) {
    //         console.log(res.data)
    //         console.log(res.status)
    //     }, function (res) {
    //         console.log(res.data)
    //         console.log(res.status)
    //     })
    // }

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