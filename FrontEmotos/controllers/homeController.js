angular.module('app').controller('homeController', 
    function($scope, $http, $location, $rootScope, $window) {

    $scope.user = {};
    $scope.rent = {};
    $scope.motos = {};
    $scope.moto = '';
    $scope.filtro = '';
    $scope.mensagemRemoverSucesso = '';
    $scope.mensagemRemoverFalha = '';
    $scope.removerTitulo = '';

    // ------------ REQUISIÇÕES PARA TRAZER LISTAS E ITENS ESPECÍFICOS ------------- //

    const token = $window.localStorage.getItem('token')
    $http.defaults.headers.common["Authorization"] = token;

    $http.get('http://localhost:8080/user/showUser/' + $rootScope.user.id)
        .then(function(res) { $scope.user = res.data;  /*console.log($scope.user) */ })
        .catch(function(erro) { console.log(erro); })

    $http.get('http://localhost:8080/moto/listMotos')
        .then(function(res) { $scope.motos = res.data; })
        .catch(function(erro) { console.log(erro); })

    $http.get('http://localhost:8080/rent/showRent')
        .then(function(res) { $scope.rent = res.data; })
        .catch(function(erro) { /* console.log(erro); */ })

    $scope.devolverMoto = function(rent){
        $http.post('http://localhost:8080/devolverMoto/', rent)
        .then(function(res){
            console.log(res)
        })
        .catch(function(erro){
            console.log(erro)
        });
    }

    // ------ REDIRECIONAMENTOS POR BOTÕES ------ //
    $scope.goToPayment = function(moto) {
        $rootScope.selectedMoto = moto;
        $location.path("/view/payment")
    }

    $scope.goToListRent = function() {
        $location.path("/view/listRent")
    }

    // ------ VALIDAÇÕES PARA ESCONDER E MOSTRAR DETERMINADAS COISAS ------ //
    $scope.esconderMoto = function(statusRent) { return statusRent; }

    $scope.userRented = function(statusRentUser) { return statusRentUser; }

    $scope.userClient = function(userType) {
        if (userType == 'client') return true;
        else return false; 
    }

    $scope.marcarMotoAlterar = function(motoAlterar){
        $scope.moto = motoAlterar;
    }

    $scope.limparFormulario = function(){
        delete $scope.moto;
        $scope.formMoto.$setPristine();
    }

    // ------------ CRUDS ------------- //
    $scope.createMoto = function() {
        $scope.moto.pricePerKm = $scope.moto.pricePerKm.replace(",", ".")

        $http.post('http://localhost:8080/moto/createMoto', $scope.moto).then(function(res) {
                if(res.status == 200){
                    delete $scope.moto;
                    $scope.formMoto.$setPristine();

                    $http.get('http://localhost:8080/moto/listMotos')
                        .then(function(res) { $scope.motos = res.data; })
                        .catch(function(erro) { console.log(erro); })
                }  
            }, function(erro) {
                console.log(erro)
            })
    }

    $scope.deleteMoto = function(moto) {
        $scope.removerTitulo = '';
        $scope.mensagemRemoverSucesso = '';
        $scope.mensagemRemoverFalha = '';
        
        $http.delete('http://localhost:8080/moto/deleteMoto/' + moto.id)
            .then(function(response) {
                $scope.removerTitulo = 'Sucesso'
                $scope.mensagemRemoverSucesso = 'Moto ' + moto.name + ' foi removida!';

                $http.get('http://localhost:8080/moto/listMotos')
                    .then(function(res) { $scope.motos = res.data; })
                    .catch(function(erro) { console.log(erro); })
            })
            .catch(function(erro) {
                console.log(erro);
                $scope.removerTitulo = 'Falha'
                $scope.mensagemRemoverFalha = 'Não foi possível remover a moto ' + moto.name;
            });
    }

    // $scope.updateMoto = function () {
    //     $http.post('/client/id').then(function (res) {
    //         console.log(res.data)
    //         console.log(res.status)
    //     }, function (res) {
    //         console.log(res.data)
    //         console.log(res.status)
    //     })
    // }

    $scope.sair = function() {
        $http.get('http://localhost:8080/logout').then(function(res) {
            if(res.$http.status == 200){
                $scope.user = res.data;
                $location.path("/view/")
            }
        })
    }

})