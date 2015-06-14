angular.module('adminClient', ['ngRoute', 'ngWebsocket'])
        .config(function ($routeProvider) {
            $routeProvider
                    .when('/', {
                        templateUrl: 'HTMLPages/manageParticipants.html',
                        controller: 'manageParticipantsController'
                    })
                    .when('/registerParticipant', {
                        templateUrl: 'HTMLPages/registerParticipant.html',
                        controller: 'registerParticipantController'
                    })
                    .when('/manageTeam', {
                        templateUrl: 'HTMLPages/manageTeam.html',
                        controller: 'manageTeamController'
                    })
                    .when('/registerTeam', {
                        templateUrl: 'HTMLPages/registerTeam.html',
                        controller: 'registerTeamController'
                    })
                    .when('/currentGame', {
                        templateUrl: 'HTMLPages/manageGameCurrent.html',
                        controller: 'manageGameCurrentController'
                    })
                    .when('/currentRound', {
                        templateUrl: 'HTMLPages/manageActiveRound.html',
                        controller: 'manageActiveRoundController'
                    })
                    .when('/servers', {
                        templateUrl: 'HTMLPages/servers.html',
                        controller: 'serverController'
                    });
        })
        .controller('indexController', function ($scope, $rootScope, websocketService, InformationService) {

            // Variables

            $scope.msg = "Index message";
            $scope.hints = [];
            $scope.MenuUserVisibility = {'display': 'block'};
            $scope.MenuGameVisibility = {'display': 'none'};

            var NewSessionConnectionMessage = {
                MessageType: "NewSessionConnectionMessage",
                Username: "Jordi"
            };
            
            // On initialization

            websocketService.start("ws://localhost:8080/ServicesModule/adminSocket");
            websocketService.sendMessage(NewSessionConnectionMessage);

            // On receiving messages

            $rootScope.$on("GetParticipantsReplyMessage", function (event, data) {
                console.log("InformationService: trying to update the participants");
                for (var u in data.Users) {
                    var user = {};
                    user.Username = data.Users[u].Username;
                    user.Email = data.Users[u].Email;
                    user.FullName = data.Users[u].FullName;
                    user.Company = data.Users[u].Company;
                    user.TelephoneNumber = data.Users[u].TelephoneNumber;
                    user.Team = data.Users[u].Team;
                    InformationService.participants[user.Username] = user;
                }

                console.log("InformationService: participants updated");
            });

            $rootScope.$on("GetTeamsRequestMessage", function (event, data) {
                console.log("InformationService: trying to update the teams")
                for (var t in data.Teams) {
                    var team = {};
                    team.Score = data.Teams[t].Score;
                    team.Workspacepath = data.Teams[t].Workspacepath;
                    team.Competition = data.Teams[t].Competition;
                    team.Id = data.Teams[t].Id;
                    team.TeamName = data.Teams[t].TeamName;
                    team.Approved = data.Teams[t].Approved;

                    if (team.Approved) {
                        InformationService.approvedTeams[team.TeamName] = team;
                    }
                    else {
                        InformationService.unapprovedTeams[team.TeamName] = team;
                    }
                }

                console.log("InformationService: teams updated");
            });

            // Scope methods

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
        });

