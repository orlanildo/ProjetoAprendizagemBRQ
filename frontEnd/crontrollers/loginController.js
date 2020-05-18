
app.controller('loginController', function ($scope, $http) {
    $scope.client = {}


    //mandar o email e a senha via post no body para a api


    $scope.goToRegister = function() {
        // Redirecionar para a tela de cadastro
        console.log('goToRegister')
    }

})


// $scope.listClients = function () {
//     // $http.get('/client').then(function(res){
//     //     console.log(res.data)
//     //     console.log(res.status)
//     // }, function(res){
//     //     console.log(res.data)
//     //     console.log(res.status)
//     // })
//     console.log("listClient")

// }

// $scope.createClient = function () {
//     // $http.post('/client').then(function(res){
//     //     console.log(res.data)
//     //     console.log(res.status)
//     // }, function(res){
//     //     console.log(res.data)
//     //     console.log(res.status)
//     // })
//     console.log("createClient")
// }

// $scope.updateClient = function () {
//     // $http.post('/client/id').then(function(res){
//     //     console.log(res.data)
//     //     console.log(res.status)
//     // }, function(res){
//     //     console.log(res.data)
//     //     console.log(res.status)
//     // })
//     console.log("updateClient")
// }

// $scope.deleteClient = function () {
//     // $http.post('/client/id').then(function(res){
//     //     console.log(res.data)
//     //     console.log(res.status)
//     // }, function(res){
//     //     console.log(res.data)
//     //     console.log(res.status)
//     // })
//     console.log("deleteClient")
// }

