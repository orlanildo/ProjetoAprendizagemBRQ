
app.controller('registerController', function ($scope, $http) {
    $scope.client = {}

    console.log('Entrou no controle de Register')

    $scope.goToHome = function() {
        window.location.href = "/home"
    }

    $scope.goToLogin = function() {
        window.location.href = "/login"
    }
})


