app.controller('registerController', function ($scope, $http) {


    $scope.createClient = function () {
        // $http.post('/client').then(function(res){
        //     console.log(res.data)
        //     console.log(res.status)
        // }, function(res){
        //     console.log(res.data)
        //     console.log(res.status)
        // })
        console.log("createClient")
    }

    $scope.cancel = function() {
        //Redirecionar para o login
        console.log('cancel')
    }
})