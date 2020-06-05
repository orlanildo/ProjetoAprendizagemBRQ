
angular.module('app').controller('paymentController', function ($scope, $http, $location, $rootScope) {
	//console.log("Imprimindo id moto: " + $rootScope.idMoto)
	//console.log("Imprimindo id usuário: " + $rootScope.user.id)

	$scope.rent = {}
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

		if($scope.rentMoto.$valid){
			if($scope.turnOverGarage){
				$scope.rent.addressRemovalId = null;
				$scope.rent.pickGarage = true;
			}
		
			if ($scope.pickGarage){
				$scope.rent.addressReceivementId = null;
				$scope.rent.turnOverGarage = true;
			}

			$scope.rent.motoRentId.statusRent = "rent"
			$scope.rent.userRentId.statusRentUser = "rented"

            $http.post('http://localhost:8080/pagamento', $scope.rent).then(function(response){
				if(response.data != null && response.data != ""){
					
					$rootScope.rent = response.data;
					$rootScope.user.userRentId = $rootScope.rent.id;
					console.log($rootScope.user)
				
					$location.path("/view/home")
				}
			}, function(response){
    			console.log(response)
    		})
	
		}
	}

	$scope.goToHome = function () {
		console.log('goToHome')
		$location.path("/view/home")
	}



})