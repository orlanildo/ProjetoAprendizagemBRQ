
angular.module('app').controller('paymentController', function ($scope, $http, $location, $rootScope) {
	
	$scope.creditCard = {}
	$scope.addressReceivement = {}
	$scope.addressRemoval = {}
	$scope.moto = $rootScope.selectedMoto
	$scope.user = $rootScope.user;

	$scope.rent.userRentId = $scope.user;
	$scope.rent.motoRentId = $scope.moto;
	$scope.rent.creditCardRentId = $scope.creditCard;
	$scope.rent.addressReceivementId = $scope.addressReceivement;
	$scope.rent.addressRemovalId = $scope.addressRemoval;

	$scope.finish = function () {
		// console.log($scope.creditCard)
		// console.log($scope.addressReceivement)
		// console.log($scope.addressRemoval)
		// console.log($scope.moto)
		// console.log($scope.user)
		console.log($scope.rent)
		console.log("finalizado com sucesso")
		//$location.path("/view/home")
	}

	$scope.goToHome = function () {
		console.log('goToHome')
		$location.path("/view/home")
	}

})