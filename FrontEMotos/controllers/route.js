
angular.module('app', ['ngRoute', 'ngAnimate'])
    .config(function ($routeProvider, $locationProvider) {
    
    //Utilizando o HTML5 History API
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
    
    $routeProvider.when('/view/', {
        templateUrl: 'view/login.html',
        controller: 'loginController'
    });
    $routeProvider.when('/view/register', {
        controller: 'registerController',
        templateUrl: 'view/register.html'
    });
    $routeProvider.when('/view/listRent', {
        controller: 'listRentController',
        templateUrl: 'view/listRent.html'
    });
    $routeProvider.when('/view/home', {
        controller: 'homeController',
        templateUrl: 'view/home.html'
    });
    $routeProvider.when('/view/payment', {
        controller: 'paymentController',
        templateUrl: 'view/payment.html'
    });
    $routeProvider.when('/view/footer', {
        templateUrl: 'view/footer.html'
    });
    $routeProvider.when('/view/header', {
        templateUrl: 'view/header.html'
    });
    $routeProvider.otherwise({redirectTo: '/view/'});

    
});
