
angular.module('app').controller('listRentController', function ($scope, $http, $location) {

    $scope.listRent = {};
    $scope.filtro = '';
    $scope.rentD = '';

    // ------------ REQUISIÇÕES PARA TRAZER LISTAS E ITENS ESPECÍFICOS ------------- //
    // const token = $window.localStorage.getItem('token')
    // $http.defaults.headers.common["Authorization"] = token;

    $http.get('http://localhost:8080/rent/listRent')
        .then(function (res) {
            $scope.listRent = res.data;
        })
        .catch(function (erro) {
            console.log(erro)
        });

    $scope.marcarRentDevolver = function (rent) {
        console.log(rent)
        $scope.rentD = rent;
    }

    $scope.returnMoto = function (rent) {
        $scope.mensagemSucesso = '';
        $scope.mensagemFalha = '';
        $scope.mensagemTitulo = '';
        $http.get('http://localhost:8080/rent/releaseRent/' + rent.id)
            .then(function (res) {
                $scope.mensagemSucesso = 'Contrato ' + rent.protocol + ' removido com sucesso!';
                $scope.mensagemTitulo = 'Sucesso';

                $http.get('http://localhost:8080/rent/listRent')
                    .then(function (res) { $scope.listRent = res.data; })
                    .catch(function (erro) { console.log(erro) })

                console.log(res)
            })
            .catch(function (erro) {
                $scope.mensagemFalha = 'Não foi possível remover o contrato ' + rent.protocol;
                $scope.mensagemTitulo = 'Erro';
                console.log(erro)
            });
    }

    /*
        // ------ REDIRECIONAMENTOS POR BOTÕES ------ //
        $scope.goToPayment = function(moto) {
            $rootScope.selectedMoto = moto;
            $location.path("/view/payment")
        }
    */

    $scope.sair = function () {
        $http.get('http://localhost:8080/logout').then(function (res) {
            if (res.$http.status == 200) {
                $location.path("/view/")
            }
        })
    }

})