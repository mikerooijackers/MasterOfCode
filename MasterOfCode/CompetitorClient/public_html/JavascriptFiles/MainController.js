angular.module('competitorLoginApp', ['ngRoute', 'ngResource'])

        .config(function ($routeProvider) {
            $routeProvider
                    .when('/', {
                        templateUrl: 'HTMLPages/login.html',
                        controller: 'loginController'
                    })

                    .when('/register', {
                        templateUrl: 'HTMLPages/register.html',
                        controller: 'registerController'
                    })
        })

        .controller('mainController', function () {

        });