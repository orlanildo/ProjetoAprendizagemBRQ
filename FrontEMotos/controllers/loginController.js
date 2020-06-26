angular.module('app').controller('loginController', 
	function ($scope, $http, $location, $rootScope) {

	//loginController.$inject = ['$rootScope', 'location', 'SETTINGS']
    $scope.client = {}
	$rootScope.usuarioLogado = {}
	$scope.mensagemLoginInvalido = ""
	$scope.mensagemEmailNull = ""
	$scope.mensagemPasswordNull = ""

    $scope.logar = function (){
		if($scope.formLogin.$valid){
			$http.post("http://localhost:8080/user/login", $scope.client).then(function(response){
				if(response.data != null && response.data != ""){
					$rootScope.user = response.data;
					$location.path("/view/home")
				}
				else{
					$scope.mensagemLoginInvalido = "E-mail ou Senha Inválida!";
				}
			})
			.catch(function(erro){
				$scope.mensagemLoginInvalido = erro.message;
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