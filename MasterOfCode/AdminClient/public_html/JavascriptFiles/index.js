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

            $scope.startCompBtn = document.getElementById("startCompBtn");
            $scope.stopCompBtn = document.getElementById("stopCompBtn");
            $scope.startRoundBtn = document.getElementById("startRoundBtn");
            $scope.pauseRoundBtn = document.getElementById("pauseRoundBtn");
            $scope.freezeRoundBtn = document.getElementById("freezeRoundBtn");
            $scope.stopRoundBtn = document.getElementById("stopRoundBtn");

            var isPausedOrFrozen = false;
            var NewSessionConnectionMessage = {
                MessageType: "NewSessionConnectionMessage",
                Username: "Jordi"
            };

            // On initialization

            websocketService.start("ws://localhost:8080/ServicesModule/adminSocket");
//            websocketService.start("ws://145.144.248.235:35785/ServicesModule/adminSocket");
            websocketService.sendMessage(NewSessionConnectionMessage);
//            disableAllPlayButtons();
//            $scope.startCompBtn.disabled = false;

            // On receiving messages

            $rootScope.$on("GetParticipantsReplyMessage", function (event, data) {
                console.log("InformationService: trying to update the participants");
                for (var u in data.Users) {
                    var user = {};
                    user.Email = data.Users[u].Email;
                    user.FullName = data.Users[u].FullName;
                    user.Company = data.Users[u].Company;
                    user.TelephoneNumber = data.Users[u].TelephoneNumber;
                    user.Team = data.Users[u].Team;
                    InformationService.participants[user.Email] = user;
                }

                console.log("InformationService: participants updated");
            });

            $rootScope.$on("GetTeamsRequestMessage", function (event, data) {
                console.log("InformationService: trying to update the teams");
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

            // Methods

            disableAllPlayButtons = function () {
                $scope.startCompBtn.disabled = true;
                $scope.stopCompBtn.disabled = true;
                $scope.startRoundBtn.disabled = true;
                $scope.pauseRoundBtn.disabled = true;
                $scope.freezeRoundBtn.disabled = true;
                $scope.stopRoundBtn.disabled = true;
            };

            enableAllPlayButtons = function () {
                $scope.startCompBtn.disabled = false;
                $scope.stopCompBtn.disabled = false;
                $scope.startRoundBtn.disabled = false;
                $scope.pauseRoundBtn.disabled = false;
                $scope.freezeRoundBtn.disabled = false;
                $scope.stopRoundBtn.disabled = false;
            };

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

            $scope.startCompetition = function () {
                enableAllPlayButtons();
                $scope.startCompBtn.disabled = true;

                var StartCompetitionRequestMessage = {
                    MessageType: "StartCompetitionRequestMessage"
                };

                websocketService.sendMessage(StartCompetitionRequestMessage);
            };

            $scope.stopCompetition = function () {
                disableAllPlayButtons();
                $scope.startCompBtn.disabled = false;

                var StopCompetitionRequestMessage = {
                    MessageType: "StopCompetitionRequestMessage"
                };

                websocketService.sendMessage(StopCompetitionRequestMessage);
            };

            $scope.startRound = function () {
                enableAllPlayButtons();
                $scope.startCompBtn.disabled = true;
                $scope.startRoundBtn.disabled = true;

                var StartRoundRequestMessage = {
                    MessageType: "StartRoundRequestMessage"
                };

                websocketService.sendMessage(StartRoundRequestMessage);
            };

            $scope.stopRound = function () {
                disableAllPlayButtons();
                $scope.stopCompBtn.disabled = false;
                $scope.startRoundBtn.disabled = false;

                var StopRoundRequestMessage = {
                    MessageType: "StopRoundRequestMessage"
                };

                websocketService.sendMessage(StopRoundRequestMessage);
            };

            $scope.pauseUnpauseRound = function () {
                if (isPausedOrFrozen) {
                    enableAllPlayButtons();

                    var ResumeRequestMessage = {
                        MessageType: "ResumeRequestMessage"
                    };

                    websocketService.sendMessage(ResumeRequestMessage);

                    $scope.pauseRoundBtn.innerHTML = "Pause";
                    isPausedOrFrozen = false;
                }
                else {
                    disableAllPlayButtons();
                    $scope.pauseRoundBtn.disabled = false;

                    var PauseRoundRequestMessage = {
                        MessageType: "PauseRoundRequestMessage"
                    };

                    websocketService.sendMessage(PauseRoundRequestMessage);

                    $scope.pauseRoundBtn.innerHTML = "Unpause";
                    isPausedOrFrozen = true;
                }
            };

            $scope.freezeUnfreezeRound = function () {
                if (isPausedOrFrozen) {
                    enableAllPlayButtons();

                    var UnFreezeRoundRequestMessage = {
                        MessageType: "UnFreezeRoundRequestMessage"
                    };

                    websocketService.sendMessage(UnFreezeRoundRequestMessage);

                    $scope.freezeRoundBtn.innerHTML = "Freeze";
                    isPausedOrFrozen = false;
                }
                else {
                    disableAllPlayButtons();
                    $scope.freezeRoundBtn.disabled = false;

                    var FreezeRoundRequestMessage = {
                        MessageType: "FreezeRoundRequestMessage"
                    };

                    websocketService.sendMessage(FreezeRoundRequestMessage);

                    $scope.freezeRoundBtn.innerHTML = "Unfreeze";
                    isPausedOrFrozen = true;
                }
            };
        });

