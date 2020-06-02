
angular.module('app').controller('paymentController', function ($scope, $http, $location) {

	/*
	$scope.address = {}
	$scope.card = {}
	$scope.moto = {}
	$scope.user = {}
	$scope.rent = {}
	*/

	$scope.finish = function () {
		console.log('finish')
		console.log("finalizado com sucesso")
		//$location.path("/view/home")
	}

	$scope.goToHome = function () {
		console.log('goToHome')
		$location.path("/view/home")
	}



})