
angular.module('app').controller('paymentController', function ($scope, $http, $location, $rootScope) {
	console.log("Imprimindo id moto: " + $rootScope.idMoto)
	console.log("Imprimindo id usuário: " + $rootScope.user.id)
	
	$scope.address = {}
	$scope.card = {}
	$scope.moto = {}
	$scope.user = {}
	$scope.rent = {}

	$scope.user = $rootScope.user;

	var url	 = 'http://localhost:8080/moto/showMoto/' + $rootScope.idMoto;
	

	$http.get(url, $rootScope.idMoto).then(function (res) {
        $scope.moto = res.data;
    })
    .catch( function(erro){
        console.log(erro);
	})
	

	$scope.finish = function () {
		console.log("finalizado com sucesso")
		//$location.path("/view/home")
	}

	$scope.goToHome = function () {
		console.log('goToHome')
		$location.path("/view/home")
	}



})