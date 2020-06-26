angular.module('app').controller('homeController', function($scope, $http, $location, $rootScope) {

    // isso é um thw wai databind basta prenchelo 
    // com os dados da api que será refletido ba tela 
    $scope.user = $rootScope.user;
    $scope.rent = {};
    $scope.motos = {};
    $scope.moto = '';
    $scope.filtro = '';
    $scope.mensagemRemoverSucesso = '';
    $scope.mensagemRemoverFalha = '';
    $scope.removerTitulo = '';

    // ------ REDIRECIONAMENTOS POR BOTÕES ------ //
    $scope.goToLogin = function() {
        $location.path("/view/")
    }

    $scope.goToPayment = function(moto) {
        console.log("goToPayment" + moto)
        $rootScope.selectedMoto = moto;
        $location.path("/view/payment")
    }

    // ------ VALIDAÇÕES PARA ESCONDER E MOSTRAR DETERMINADAS COISAS ------ //
    $scope.esconderMoto = function(motoRent) {
        if (motoRent == 'rent') {
            return true;
        } else {
            return false;
        }
    }

    $scope.userRented = function(userRent) {
        if (userRent == 'rented') {
            return true;
        } else {
            return false;
        }
    }

    $scope.userClient = function(userType) {
        if (userType == 'client') {
            return true;
        } else {
            return false;
        }
    }

    $scope.marcarMotoAlterar = function(motoAlterar){
        $scope.moto = motoAlterar;
    }

    $scope.limparFormulario = function(){
        delete $scope.moto;
        $scope.formMoto.$setPristine();
    }

    // ------------ REQUISIÇÕES PARA TRAZER LISTAS E ITENS ESPECÍFICOS ------------- //
    $http.get('http://localhost:8080/showRent/' + $scope.user.id).then(function(res) {
            $scope.rent = res.data;
        })
        .catch(function(erro) {
            console.log(erro);
        })

        $http.get('http://localhost:8080/moto/listMotos').then(function(res) {
            $scope.motos = res.data;
        })
        .catch(function(erro) {
            console.log(erro);
        });

    $scope.devolverMoto = function(rent){
        $http.post('http://localhost:8080/devolverMoto/', rent)
        .then(function(res){
            console.log(res)
        })
        .catch(function(erro){
            console.log(erro)
        });
    }

    // ------------ CRUDS ------------- //
    $scope.createMoto = function() {
        $http.post('http://localhost:8080/moto/createMoto', $scope.moto).then(function(res) {
            if(res.status == 200){
                delete $scope.moto;
                $scope.formMoto.$setPristine();

                $http.get('http://localhost:8080/moto/listMotos').then(function(res) {
                        $scope.motos = res.data;
                    })
                    .catch(function(erro) {
                        console.log(erro);
                    })
            }  
        }, function(res) {
            console.log(res.data)
            console.log(res.status)
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

                $http.get('http://localhost:8080/moto/listMotos').then(function(res) {
                        $scope.motos = res.data;
                    })
                    .catch(function(erro) {
                        console.log(erro);
                    })
                
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


    // ----- ANTIGA FORMA DE APAGAR SESSÃO A PARTIR DA HOME ----- //
    $scope.sair = function() {
        $http.get('http://localhost:8080/sair').then(function(res) {
            $scope.user = res.data;
            $location.path("/view/")
        })
    }

})