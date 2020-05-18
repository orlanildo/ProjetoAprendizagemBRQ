const app = angular.module('app', ['ngRoute'])


app.config(function($routeProvider, $locationProvider){
    $routeProvider.when('/login', {
        templateUrl: './views/login.html',
        controller: 'loginController'
    }).when('/register', {
        templateUrl: './views/register.html',
        controller: 'registerController'
    }).otherwise({ rediretTo: '/' })

    $locationProvider.html5Mode(true)
})