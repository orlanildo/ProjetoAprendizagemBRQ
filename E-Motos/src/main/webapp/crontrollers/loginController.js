
app.controller('loginController', function ($scope, $http, $location) {
    $scope.client = {}

    console.log('Entrou no controle de login')

    $scope.goToHome = function() {
        console.log('goToHome')
        window.location.href = "/home"
    }

    $scope.goToRegister = function() {
        console.log('goToRegister')
        window.location.href = "/register"
    }
    
    $scope.logar = function (){
    	console.log($scope.client)
    	
    	$http.post("user/login", $scope.client).then(function(response){
    		console.log(response)
    		if(response.data != null){
    			console.log(response.data)
    			window.location.href = "/home"
    				//$location.path("/home")
    			//return response.data
    		}
    	}, function(response){
    		console.log(response)
    	})
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

