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
                    .when('/assignment', {
                        templateUrl: 'Pages/assignment.html',
                        controller: 'manageAssignmentController'
                    })
                    .when('/competition', {
                        templateUrl: 'Pages/competition.html',
                         controller: 'manageCompetitionController'
                    });
        })

        .controller('indexController', function ($scope, websocketService) {
            $scope.msg = "...";

            websocketService.start("ws://localhost:8080/ServicesModule/spectatorSocket");
            var NewSessionConnectionMessage = {
                MessageType: "NewSessionConnectionMessage",
            };
            websocketService.sendMessage(NewSessionConnectionMessage);
        });
