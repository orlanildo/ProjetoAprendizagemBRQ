angular.module('app').controller('paymentController', function($scope, $http, $location, $rootScope) {

    // ---- ITENS DO FORMULARIO DE PAGAMENTO ---- //
    $scope.creditCard = {}
    $scope.addressReceivement = {}
    $scope.addressRemoval = {}

    // ---- INFORMAÇÕES TRAZIDAS DA HOME PARA PAGAMENTO ---- //
    $scope.moto = $rootScope.selectedMoto
    $scope.user = $rootScope.user;

    // ----- CONSTRUINDO O RENT COM SEUS PARAMETROS ----- //
    $scope.rent = {}
    $scope.rent.userRentId = $scope.user;
    $scope.rent.motoRentId = $scope.moto;
    $scope.rent.creditCardRentId = $scope.creditCard;
    $scope.rent.addressReceivementId = $scope.addressReceivement;
    $scope.rent.addressRemovalId = $scope.addressRemoval;

    // ------ VALIDAÇÃO --------
    $scope.esconderForm = function(){
        return false
    };
    $scope.esconderMensagem = function(){
        return true
    };
    
    // ----- FINALIZANDO O PEDIDO ----- //
    $scope.finish = function() {
        
        if ($scope.rentMoto.$valid) {

            $scope.rent.finalPrice = $scope.kms * $scope.moto.pricePerKm;

            console.log("Finalizando..")

            if ($scope.rentHelmet) {
                $scope.rent.helmet = true;
                $scope.rent.finalPrice += 20;
            }

            if ($scope.turnOverGarage) {
                $scope.rent.addressRemovalId = null;
                $scope.rent.pickGarage = true;
            }

            if ($scope.pickGarage) {
                $scope.rent.addressReceivementId = null;
                $scope.rent.turnOverGarage = true;
            }

            console.log('--------------------------')
            console.log($scope.rent)

            $scope.rent.motoRentId.statusRent = "rent"
            $scope.rent.userRentId.statusRentUser = "rented"

            console.log($scope.rent)

            $http.post('http://localhost:8080/payment', $scope.rent).then(function(response) {
                if (response.data != null && response.data != "") {

                    $rootScope.rent = response.data;
                    $rootScope.user.userRentId = $rootScope.rent.id;

                    $http.get('http://localhost:8080/showRent/' + $scope.user.id).then(function(res) {
                            $scope.rent = res.data;
                        })
                        .catch(function(erro) {
                            console.log(erro);
                        })

                    $scope.esconderForm = function(){
                        return true
                    };
                    $scope.esconderMensagem = function(){
                        return false
                    };
                }
            }, function(response) {
                console.log(response)
            })

        }
    }

    // --- NAVEGAÇÃO --- //
    $scope.goToHome = function() {
        console.log('goToHome')
        $location.path("/view/home")
    }

    $scope.sair = function() {
        $http.get('http://localhost:8080/sair').then(function(res) {
            $scope.user = res.data;
            $location.path("/view/")
        })
    }


})