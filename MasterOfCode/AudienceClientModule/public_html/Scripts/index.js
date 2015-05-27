angular.module('audienceClient', ['ngRoute', 'ngWebsocket'])
        .config(function ($routeProvider) {
            $routeProvider
                    .when('/', {
                        templateUrl: 'Pages/homepage.html',
                        controller: 'manageHomepageController'
                    })
                    .when('/teams', {
                        templateUrl: 'Pages/teams.html',
                        controller: 'manageTeamsController'
                    })
                    .when('/scores', {
                        templateUrl: 'Pages/scores.html',
                        controller: 'manageScoresController'
                    })
                    .when('/rounds', {
                        templateUrl: 'Pages/rounds.html',
                        controller: 'manageRoundsController'
                    })
                    .when('/newsfeed', {
                        templateUrl: 'Pages/newsfeed.html',
                        controller: 'manageNewsfeedController'
                    })
                    .when('/about', {
                        templateUrl: 'Pages/about.html',
                         controller: 'manageAboutController'
                    });
        })

        .controller('indexController', function ($scope) {

        });
