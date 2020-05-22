
app.controller('registerController', function ($scope, $http) {
    $scope.client = {}

    console.log('Entrou no controle de Register')
    
    /*
    $scope.goToHome = function() {
        window.location.href = "/home"
    }
    */
    
    $scope.goToHome = function() {
    	console.log($scope.client)
    	
    	$http.post("/createClient", $scope.client).then(function(response){
    		console.log(response)
    	}, function(response){
    		console.log(response)
    	})
    	
        //window.location.href = "/home"
    }

    $scope.goToLogin = function() {
        window.location.href = "/login"
    }
})


