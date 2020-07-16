angular.module('app').controller('loginController', 
	function ($scope, $http, $location, $rootScope, $window) {

	//loginController.$inject = ['$rootScope', 'location', 'SETTINGS']
    $scope.client = {}
	$rootScope.usuarioLogado = {}
	$scope.mensagemLoginInvalido = ""
	$scope.mensagemEmailNull = ""
	$scope.mensagemPasswordNull = ""

    $scope.logar = function (){
		if($scope.formLogin.$valid){
			$http.post("http://localhost:8080/login", $scope.client)
				.then(function(response, config){
					if(response.data != null){
						$window.localStorage.setItem("token", response.data.token)
						$rootScope.user = response.data;
						$location.path("/view/home")
					}
			})
			.catch(function(erro){
				$scope.mensagemLoginInvalido = "E-mail ou Senha Inválida!";
			});
		}
		else{
			if($scope.client.email == null && $scope.client.password == null){
				$scope.mensagemEmailNull = "Preencha o e-mail!"
				$scope.mensagemPasswordNull = "Preencha a senha!"
			}
			else if($scope.client.password == null){$scope.mensagemPasswordNull = "Preencha a senha!"}
			else if($scope.client.password == null){$scope.mensagemEmailNull = "Preencha o e-mail!"}
		}
		
	}

    $scope.goToRegister = function (){
		$location.path("/view/register")
	} 

	$scope.goToPayment = function (){
		$location.path("/view/payment")
    } 
})