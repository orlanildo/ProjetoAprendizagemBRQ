angular.module('app').controller('registerController', function ($scope, $http, $location) {
    $scope.addressClient = {}
    $scope.client = {}
    $scope.mensagemEndInvalido = '';

    console.log("Entrando no register")

    // --------- CRUD ------------
    $scope.saveClient = function () {  
        $scope.client.addressUser = $scope.addressClient

        if ($scope.formRegister.$valid) {
            if ($scope.client != null && $scope.client != '') {
                if ($scope.client.addressUser != null && $scope.client.addressUser != '') {
                    console.log($scope.client.addressUser.stret)
                    console.log("Registrando...")
                    $http.post("http://localhost:8080/user/createUser", $scope.client).then(function (response) {
                        console.log(response.data)
                        $location.path("/view/")
                    }, function (response) {
                        console.log(response.status)
                    })
                }
                else {
                    console.log("Deu erro...")
                    $scope.mensagemEndInvalido = "CEP Inválido"
                }   
            }
        }
    }

    // -------- PESQUISANDO/VALIDANDO CEP ---------
    var vm = this;
    $scope.pesquisarCep = function(zipCode) {
  
        var cepValido = /^[0-9]{5}[-]?[0-9]{3}$/.test(zipCode);
  
        if (cepValido) {
  
          $http.get("https://viacep.com.br/ws/" + zipCode + "/json/").then(
            function(response) {
                if(response.data.erro != true){
                    vm.endereco = response.data;
                    $scope.addressClient.street = vm.endereco.logradouro;
                    $scope.addressClient.neighborhood = vm.endereco.bairro;
                    $scope.addressClient.city = vm.endereco.localidade;
                    $scope.addressClient.state = vm.endereco.uf;
                }
                else{
                    alert('Cep inválido');
                }
            },
            function(error) {
              if (error.status === 404) {
                alert('Cep não encontrado');
              }
            } //callback para tratameno de falhas
          );
        } else {
          alert('CEP inválido!');
        }
      }

    
    // ------------ NAVEGAÇÃO --------------
    $scope.goToLogin = function () {
        $location.path("/view/")
    }
})