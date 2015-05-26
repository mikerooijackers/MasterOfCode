angular.module('audienceClient', ['ngRoute', 'ngWebsocket'])
        .config(function ($routeProvider) {
            $routeProvider
                    .when('/', {
                        templateUrl: 'Pages/homepage.html'
                        //controller: 'manageParticipantsController'
                    })
                    .when('/teams', {
                        templateUrl: 'Pages/teams.html'
                        //controller: 'manageParticipantsController'
                    })
                    .when('/scores', {
                        templateUrl: 'Pages/scores.html'
                       // controller: 'manageParticipantsController'
                    })
                    .when('/rounds', {
                        templateUrl: 'Pages/rounds.html'
                        //controller: 'manageParticipantsController'
                    })
                    .when('/newsfeed', {
                        templateUrl: 'Pages/newsfeed.html'
                        //controller: 'manageParticipantsController'
                    })
                    .when('/about', {
                        templateUrl: 'Pages/about.html'
                       // controller: 'manageParticipantsController'
                    });
        })
        
        .controller('indexController', function ($scope) {
           
        });
