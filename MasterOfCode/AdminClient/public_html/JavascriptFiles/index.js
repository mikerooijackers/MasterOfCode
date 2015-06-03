angular.module('adminClient', ['ngRoute', 'ngWebsocket'])
        .config(function ($routeProvider) {
            $routeProvider
                    .when('/', {
                        templateUrl: 'HTMLPages/manageParticipants.html',
                        controller: 'manageParticipantsController'
                    })
                    .when('/registerParticipant', {
                        templateUrl: 'HTMLPages/registerParticipant.html',
                        controller: 'manageParticipantsController'
                    })
                    .when('/manageTeam', {
                        templateUrl: 'HTMLPages/manageTeam.html',
                        controller: 'manageParticipantsController'
                    })
                    .when('/registerTeam', {
                        templateUrl: 'HTMLPages/registerTeam.html',
                        controller: 'manageParticipantsController'
                    })
                    .when('/currentGame', {
                        templateUrl: 'HTMLPages/manageGameCurrent.html',
                        controller: 'manageParticipantsController'
                    })
                    .when('/currentRound', {
                        templateUrl: 'HTMLPages/manageActiveRound.html',
                        controller: 'manageParticipantsController'
                    })
                    .when('/servers', {
                        templateUrl: 'HTMLPages/servers.html',
                        controller: 'manageParticipantsController'
                    });
        })
        .controller('indexController', function ($scope, $rootScope, websocketService, InformationService) {
            $scope.msg = "Index message";
            $scope.hints = [];

            websocketService.start("ws://localhost:8080/ServicesModule/adminSocket");

            var NewSessionConnectionMessage = {
                MessageType: "NewSessionConnectionMessage",
                Username: "Jordi"
            };

            websocketService.sendMessage(NewSessionConnectionMessage);

            $scope.MenuUserVisibility = {'display': 'block'};
            $scope.MenuGameVisibility = {'display': 'none'};

            $scope.showCategoryUsers = function () {
                $scope.MenuUserVisibility = {'display': 'block'};
                $scope.MenuGameVisibility = {'display': 'none'};
            };
            $scope.showCategoryGame = function () {
                $scope.MenuUserVisibility = {'display': 'none'};
                $scope.MenuGameVisibility = {'display': 'block'};
            };
            $scope.showCategoryServers = function () {
                $scope.MenuUserVisibility = {'display': 'none'};
                $scope.MenuGameVisibility = {'display': 'none'};
            };

            $rootScope.$on("GetParticipantsReplyMessage", function (event, data) {
                for (var u in data.Users) {
                    var user = {};
                    user.Username = data.Users[u].Username;
                    user.Email = data.Users[u].Email;
                    user.FullName = data.Users[u].FullName;
                    InformationService.participants[user.Username] = user;
                    console.log(InformationService.participants);
                }
            });
        });

