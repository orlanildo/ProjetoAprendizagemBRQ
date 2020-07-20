
angular.module('app').controller('paymentController', function ($scope, $http, $location, $rootScope) {
    // ---- ADDRESSDEFAULT ---- //
    $scope.addressDefault = {
        street: "R. Boa Vista", number: 254,
        neighborhood: "Centro Histórico de São Paulo", city: "São Paulo",
        state: "SP", zipCode: "01014-000"
    }

    // ---- ITENS DO FORMULARIO DE PAGAMENTO ---- //
    $scope.creditCard = ''
    $scope.addressReceivement = ''
    $scope.addressRemoval = ''
    var finalizarAluguel = false;

    // ---- INFORMAÇÕES TRAZIDAS DA HOME PARA PAGAMENTO ---- //
    $scope.moto = $rootScope.selectedMoto
    $scope.user = {};

    // ----- CONSTRUINDO O RENT COM SEUS PARAMETROS ----- //
    $scope.rent = {}
    $scope.rent.userRentId = { id: $rootScope.user.id }
    $scope.rent.motoRentId = { id: $rootScope.selectedMoto.id }
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
                    if (address == "addressReceivement") {
                        $scope.addressReceivement.street = response.data.logradouro;
                        $scope.addressReceivement.neighborhood = response.data.bairro;
                        $scope.addressReceivement.city = response.data.localidade;
                        $scope.addressReceivement.state = response.data.uf;
                    } else {
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

    $scope.criarRent = function () {
        $scope.mensagemReceber = ''
        $scope.mensagemEntregar = ''
        $scope.mensagemCartao = ''
        finalizarAluguel = false;

        console.log('Marcando')
        //Endereço para pegar
        if ($scope.myaddressPickGarage)
            $scope.rent.addressReceivementId = $scope.user.addressUser;

        if ($scope.myaddressPickGarage != true && $scope.addressDefaultPickGarage != true)
            $scope.rent.addressReceivementId = $scope.addressReceivement;

        if ($scope.addressDefaultPickGarage)
            $scope.rent.addressReceivementId = $scope.addressDefault;

        if ($scope.rent.addressReceivementId == null || $scope.rent.addressReceivementId == '')
            $scope.mensagemReceber = 'Necessário adicionar um endereço para recebimento/retirada!';

        //Endereço pra devolver
        if ($scope.myaddressTurnOverGarage)
            $scope.rent.addressRemovalId = $scope.user.addressUser;

        if ($scope.addressDefaultTurnOverGarage)
            $scope.rent.addressRemovalId = $scope.addressDefault;

        if ($scope.myaddressTurnOverGarage != true && $scope.addressDefaultTurnOverGarage != true)
            $scope.rent.addressRemovalId = $scope.addressRemoval;

        if ($scope.rent.addressRemovalId == null || $scope.rent.addressRemovalId == '')
            $scope.mensagemEntregar = 'Necessário adicionar um endereço para entrega/devolução!';

        //Cartão de crédito
        $scope.rent.creditCardRentId = $scope.creditCard;
        if ($scope.rent.creditCardRentId == '' || $scope.rent.creditCardRentId == null)
            $scope.mensagemCartao = 'Necessário adicionar um cartão de crédito para eventual pagamento!'


        if ($scope.mensagemCartao == '' && $scope.mensagemEntregar == '' && $scope.mensagemReceber == '')
            finalizarAluguel = true;

        console.log($scope.rent.addressReceivementId)
        console.log($scope.rent.addressRemovalId)
        console.log($scope.rent.creditCardRentId)
    }

    // ----- FINALIZANDO O PEDIDO ----- //
    $scope.finish = function () {

        console.log("Finalizando!");
        if (finalizarAluguel) {
            console.log("Finalizando 2");
            // $http.post('http://localhost:8080/rent/createRent', $scope.rent)
            //     .then(function(response) {
            //         if (response.data != null && response.data != "") {
            //             $scope.rent = response.data;

            //             console.log($scope.rent)
            //             $scope.esconderForm = function(){ return true };
            //             $scope.esconderMensagem = function(){ return false };
            //         }
            //     }, function(error) {
            //         console.log(error)
            // })  
        }else{
            alert('Ainda faltam informações!');
        }

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