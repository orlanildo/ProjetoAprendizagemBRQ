
angular.module('app').controller('paymentController', function ($scope, $http, $location, $rootScope) {
    // ---- ADDRESSDEFAULT ---- //
    $scope.addressDefault = {
        street: "R. Boa Vista", number: 254,
        neighborhood: "Centro Histórico de São Paulo", city: "São Paulo",
        state: "SP", zipCode: "01014-000"
    }

    // ---- ITENS DO FORMULARIO DE PAGAMENTO ---- //
    $scope.creditCard = {}
    $scope.addressReceivement = {}
    $scope.addressRemoval = {}

    // ---- INFORMAÇÕES TRAZIDAS DA HOME PARA PAGAMENTO ---- //
    $scope.moto = $rootScope.selectedMoto
    $scope.user = {};

    // ----- CONSTRUINDO O RENT COM SEUS PARAMETROS ----- //
    $scope.rent = {}
    $scope.rent.userRentId = { id: $rootScope.user.id }
    $scope.rent.motoRentId = { id: $rootScope.selectedMoto.id }
    $scope.rent.creditCardRentId = $scope.creditCard;
    $scope.rent.addressReceivementId = $scope.addressReceivement;
    $scope.rent.addressRemovalId = $scope.addressRemoval;

    // -------- PESQUISANDO/VALIDANDO CEP ---------
    $scope.findZipCode = function (zipCode, address) {
        let zipCodeValid = /^[0-9]{5}[-]?[0-9]{3}$/.test(zipCode);

        if (zipCodeValid) {
            var req = {
                method: 'GET',
                url: "https://viacep.com.br/ws/" + zipCode + "/json/",
                headers: { 'Authorization': undefined }
            }
               
            $http(req).then(function (response) {
                if (response.data.erro != true) {
                    if(address == "addressReceivement") {
                        $scope.addressReceivement.street = response.data.logradouro;
                        $scope.addressReceivement.neighborhood = response.data.bairro;
                        $scope.addressReceivement.city = response.data.localidade;
                        $scope.addressReceivement.state = response.data.uf;
                    }else {
                        $scope.addressRemoval.street = response.data.logradouro;
                        $scope.addressRemoval.neighborhood = response.data.bairro;
                        $scope.addressRemoval.city = response.data.localidade;
                        $scope.addressRemoval.state = response.data.uf;
                    }
                }
                else {
                    alert('Cep inválido');
                }
            },
                function (error) {
                    if (error.status === 404) {
                        alert('Cep não encontrado');
                    }
                } //callback para tratameno de falhas
            );
        } else {
            alert('CEP inválido!');
        }
    }

    // ----- GET User Loged----- //
    $http.get('http://localhost:8080/user/showUser/' + $rootScope.user.id)
        .then(function (res) { $scope.user = res.data; })
        .catch(function (erro) { console.log(erro); })

    // ------ VALIDAÇÃO --------
    $scope.esconderForm = function () {
        return false
    };

    $scope.esconderMensagem = function () {
        return true
    };

    // ----- FINALIZANDO O PEDIDO ----- //
    $scope.finish = function () {

        if ($scope.myaddressPickGarage)
            $scope.rent.addressReceivementId = $scope.user.addressUser;
        
        if($scope.myaddressTurnOverGarage)
            $scope.rent.addressRemovalId = $scope.user.addressUser;

        if ($scope.addressDefaultPickGarage) 
            $scope.rent.addressReceivementId = $scope.addressDefault;

        if ($scope.addressDefaultTurnOverGarage) 
            $scope.rent.addressRemovalId = $scope.addressDefault;

        if($scope.myaddressPickGarage != true && $scope.addressDefaultPickGarage != true)
            $scope.rent.addressReceivementId = $scope.addressReceivement;
        
        if($scope.myaddressTurnOverGarage != true && $scope.addressDefaultTurnOverGarage != true)
            $scope.rent.addressRemovalId = $scope.addressRemoval;

        $http.post('http://localhost:8080/rent/createRent', $scope.rent)
            .then(function(response) {
                if (response.data != null && response.data != "") {
                    $rootScope.rent = response.data;

                    $scope.esconderForm = function(){ return true };
                    $scope.esconderMensagem = function(){ return false };

                    $location.path("/view/home")
                }
            }, function(error) {
                console.log(error)
        })
    }

    // --- NAVEGAÇÃO --- //
    $scope.goToHome = function () {
        $location.path("/view/home")
    }

    $scope.sair = function () {
        $http.get('http://localhost:8080/sair').then(function (res) {
            $scope.user = res.data;
            $location.path("/view/")
        })
    }

})