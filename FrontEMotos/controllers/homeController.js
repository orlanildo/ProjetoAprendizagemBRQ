angular.module('app').controller('homeController',
    function ($scope, $http, $location, $rootScope, $window) {

        $scope.user = {};
        $scope.rent = {};
        $scope.motos = {};
        $scope.moto = '';
        $scope.motoR = '';
        $scope.opc = 1;
        $scope.tituloModal = 'Cadastrar';
        $scope.tituloModalConfirmar = '';
        $scope.filtro = '';

        // ------------ REQUISIÇÕES PARA TRAZER LISTAS E ITENS ESPECÍFICOS ------------- //

        const token = $window.localStorage.getItem('token')
        $http.defaults.headers.common["Authorization"] = token;

        $http.get('http://localhost:8080/user/showUser/' + $rootScope.user.id)
            .then(function (res) { $scope.user = res.data;  /*console.log($scope.user) */ })
            .catch(function (erro) { console.log(erro); })

        $http.get('http://localhost:8080/moto/listMotos')
            .then(function (res) { $scope.motos = res.data; })
            .catch(function (erro) { console.log(erro); })

        $http.get('http://localhost:8080/rent/showRent')
            .then(function (res) { $scope.rent = res.data; })
            .catch(function (erro) { /* console.log(erro); */ })

        $scope.devolverMoto = function (rent) {
            $http.post('http://localhost:8080/devolverMoto/', rent)
                .then(function (res) {
                    console.log(res)
                })
                .catch(function (erro) {
                    console.log(erro)
                });
        }

        // ------ REDIRECIONAMENTOS POR BOTÕES ------ //
        $scope.goToPayment = function (moto) {
            $rootScope.selectedMoto = moto;
            $location.path("/view/payment")
        }

        $scope.goToListRent = function () {
            $location.path("/view/listRent")
        }

        // ------ VALIDAÇÕES PARA ESCONDER E MOSTRAR DETERMINADAS COISAS ------ //
        $scope.esconderMoto = function (statusRent) { return statusRent; }

        $scope.userRented = function (statusRentUser) { return statusRentUser; }

        $scope.userClient = function (userType) {
            if (userType == 'client') return true;
            else return false;
        }

        $scope.marcarMotoAlterar = function (motoAlterar) {
            $scope.moto = motoAlterar;
            $scope.opc = 2;
            $scope.tituloModal = 'Alterar';
            $scope.tituloModalConfirmar = 'Realmente deseja alterar está moto?';
        }

        $scope.marcarDeleteMoto = function (motoRemover) {
            $scope.motoR = motoRemover;
            $scope.tituloModalConfirmar = 'Realmente deseja remover está moto?';
        }

        $scope.limparFormulario = function () {
            delete $scope.moto;
            delete $scope.motoR;
            $scope.formMoto.$setPristine();
            $scope.opc = 1;
            $scope.tituloModal = 'Cadastrar';
        }

        // ------------ CRUDS ------------- //
        $scope.createMoto = function (moto) {
            $scope.mensagemTitulo = '';
            $scope.mensagemSucesso = '';
            $scope.mensagemFalha = '';
            // $scope.moto.pricePerKm = $scope.moto.pricePerKm.replace(",", ".")

            $http.post('http://localhost:8080/moto/createMoto', $scope.moto).then(function (res) {
                if (res.status == 200) {

                    $http.get('http://localhost:8080/moto/listMotos')
                        .then(function (res) { $scope.motos = res.data; })
                        .catch(function (erro) { console.log(erro); });

                    $scope.mensagemTitulo = 'Sucesso'
                    $scope.mensagemSucesso = 'Moto ' + moto.name + ' foi cadastrada!';
                    delete $scope.moto;
                    $scope.formMoto.$setPristine();
                }
            }, function (erro) {
                console.log(erro)
                $scope.mensagemTitulo = 'Falha'
                $scope.mensagemFalha = 'Não foi possível alterar a moto ' + moto.name;
            })
        }

        $scope.deleteMoto = function (moto) {
            $scope.mensagemTitulo = '';
            $scope.mensagemSucesso = '';
            $scope.mensagemFalha = '';

            $http.delete('http://localhost:8080/moto/deleteMoto/' + moto.id)
                .then(function (response) {
                    $scope.mensagemTitulo = 'Sucesso'
                    $scope.mensagemSucesso = 'Moto ' + moto.name + ' foi removida!';

                    $http.get('http://localhost:8080/moto/listMotos')
                        .then(function (res) { $scope.motos = res.data; })
                        .catch(function (erro) { console.log(erro); })
                })
                .catch(function (erro) {
                    console.log(erro);
                    $scope.mensagemTitulo = 'Falha'
                    $scope.mensagemFalha = 'Não foi possível remover a moto ' + moto.name;
                });
        }

        $scope.updateMoto = function (moto) {
            $http.put('http://localhost:8080/moto/updateMoto/' + moto.id, moto)
            .then(function (res) {
                if (res.status == 200) {

                    $http.get('http://localhost:8080/moto/listMotos')
                        .then(function (res) { $scope.motos = res.data; })
                        .catch(function (erro) { console.log(erro); });

                    $scope.mensagemTitulo = 'Sucesso'
                    $scope.mensagemSucesso = 'Moto ' + moto.name + ' foi alterada!';
                    delete $scope.moto;
                    $scope.formMoto.$setPristine();
                }
            }, function (res) {
                console.log(res.data)
                console.log(res.status)
            })
        }

        $scope.sair = function () {
            $http.get('http://localhost:8080/logout').then(function (res) {
                if (res.$http.status == 200) {
                    $scope.user = res.data;
                    $location.path("/view/")
                }
            })
        }

    })