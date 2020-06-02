  
angular.module('app').config(function ($routeProvider, $locationProvider) {
    $routeProvider
        .when('/view/', {
            templateUrl: 'view/login.html',
            controller: 'loginController'
        })
        .when('/view/register', {
            controller: 'registerController',
            templateUrl: 'view/register.html'
        })
        .when('/view/home', {
            controller: 'homeController',
            templateUrl: 'view/home.html'
        })
        .when('/view/payment', {
            controller: 'paymentController',
            templateUrl: 'view/payment.html'
        })
        .when('/view/footer', {
            templateUrl: 'view/footer.html'
        })
        .when('/view/header', {
            templateUrl: 'view/header.html'
        })


    //Utilizando o HTML5 History API
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
});
