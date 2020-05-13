
app.controller('loginController', function ($scope, $http) {
    $scope.client = {}


    $scope.listClients = function () {
        // $http.get('/client').then(function(res){
        //     console.log(res.data)
        //     console.log(res.status)
        // }, function(res){
        //     console.log(res.data)
        //     console.log(res.status)
        // })
        console.log("listClient")

    }

    $scope.createClient = function () {
        // $http.post('/client').then(function(res){
        //     console.log(res.data)
        //     console.log(res.status)
        // }, function(res){
        //     console.log(res.data)
        //     console.log(res.status)
        // })
        console.log("createClient")
    }

    $scope.updateClient = function () {
        // $http.post('/client/id').then(function(res){
        //     console.log(res.data)
        //     console.log(res.status)
        // }, function(res){
        //     console.log(res.data)
        //     console.log(res.status)
        // })
        console.log("updateClient")
    }

    $scope.deleteClient = function () {
        // $http.post('/client/id').then(function(res){
        //     console.log(res.data)
        //     console.log(res.status)
        // }, function(res){
        //     console.log(res.data)
        //     console.log(res.status)
        // })
        console.log("deleteClient")
    }

})

