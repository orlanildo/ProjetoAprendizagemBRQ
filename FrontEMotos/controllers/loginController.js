angular.module('app').controller('loginController', 
	function ($scope, $http, $location, $rootScope) {

	//loginController.$inject = ['$rootScope', 'location', 'SETTINGS']
    $scope.client = {}
	$rootScope.usuarioLogado = {}

    $scope.logar = function (){
		console.log("logar")

    	$http.post("http://localhost:8080/user/login", $scope.client).then(function(response){
    		if(response.data != null && response.data != ""){
				$rootScope.user = response.data;
				console.log($rootScope.user)
				$location.path("/view/home")
    		}
    	}, function(response){
    		console.log(response)
    	})
	}

    $scope.goToRegister = function (){
		$location.path("/view/register")
    } 
})