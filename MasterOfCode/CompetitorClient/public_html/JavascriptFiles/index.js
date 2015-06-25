angular.module('competitorClientApp', ['ngRoute', 'ngWebsocket', 'ngResource'])

        .config(function ($routeProvider) {
            $routeProvider
                    .when('/', {
                        templateUrl: 'HTMLPages/home.html',
                        controller: 'homeController'
                    })

                    .when('/codeFiles', {
                        templateUrl: 'HTMLPages/editorView.html',
                        controller: 'editorController'
                    })

                    .when('/compiling', {
                        templateUrl: 'HTMLPages/compiling.html',
                        controller: 'compileController'
                    })

                    .when('/javadoc', {
                        templateUrl: 'HTMLPages/javadoc.html',
                        controller: 'javadocController'
                    })

                    .when('/hints', {
                        templateUrl: 'HTMLPages/hints.html',
                        controller: 'hintsController'
                    })

                    .when('/turnIn', {
                        templateUrl: 'HTMLPages/turnin.html',
                        controller: 'turninController'
                    })

                    .when('/testing', {
                        templateUrl: 'HTMLPages/tests.html',
                        controller: 'testingController'
                    })

                    .when('/newsfeedOverview', {
                        templateUrl: 'HTMLPages/newsFeedOverview.html',
                        controller: 'newsFeedController'
                    })

                    .when('/account', {
                        templateUrl: 'HTMLPages/account.html',
                        controller: 'accountController'
                    });
        })

        .controller('mainController', function ($scope, SocketService, $rootScope, InformationService, $interval, $location) {
            if (localStorage.getItem('userInformation') === null) {
                window.location.href = "http://localhost:8383/CompetitorClient/LoginPage.html";
            }
            $scope.currentScore = 0;
            $scope.difficulty = 1;
            InformationService.user = JSON.parse(localStorage.getItem('userInformation'));
            console.log(InformationService.user);
            if (InformationService.user.team) {
                SocketService.start("ws://localhost:35785/ServicesModule/contestantSocket");
                var NewSessionConnectionMessage = {MessageType: "NewUserSessionConnectionMessage", TeamId: InformationService.user.team.id};
                SocketService.sendMessage(NewSessionConnectionMessage);
            } else {
                $location.path('/account');
            }

            $scope.hoursRemaining = 0;
            $scope.minutesRemaining = 0;
            $scope.secondsRemaining = 0;

            $rootScope.$on("HintReplyMessage", function (event, data) {
                InformationService.hints.push(data.HintMessage);
            });

            $rootScope.$on("OtherTeamScoreReplyMessage", function (event, data) {
                var teamScores = document.getElementById("otherTeamScores");
                var row = teamScores.insertRow();
                var cellTeam = row.insertCell();
                var cellScore = row.insertCell();

                cellTeam.innerHTML = data.TeamName;
                cellScore.innerHTML = data.TeamScore;
            });
            
            $rootScope.$on("SubmitReplyMessage", function(event, data) {
                console.log(data.Succeeded);
                if (data.Succeeded) {
                    InformationService.roundBusy = false;
                    $location.path('/account');
                }
            });

            $rootScope.$on("StartRoundReplyMessage", function (event, data) {
                InformationService.assignCreatorName = data.AssignCreatorName;
                InformationService.assignCreatorCompany = data.AssignCreatorCompany;
                InformationService.assignCreatorWeb = data.AssignCreatorWeb;

                InformationService.assignName = data.AssignName;
                InformationService.assignDescriptionCompetitors = data.AssignDescriptionCompetitors;
                InformationService.assignDescriptionSpectators = data.AssignDescriptionSpectators;

                InformationService.roundBusy = true;

                $scope.difficulty = data.AssignDifficulty;

                $scope.hoursRemaining = Math.floor(data.Duration / 3600);
                var remaining = data.Duration % 3600;
                $scope.minutesRemaining = Math.floor(remaining / 60);
                $scope.secondsRemaining = remaining % 60;
                $scope.currentScore = data.Duration - $scope.difficulty;

                $scope.timer = $interval(function () {
                    $scope.secondsRemaining--;
                    if ($scope.secondsRemaining < 0) {
                        $scope.minutesRemaining--;
                        $scope.secondsRemaining = 59;
                    }
                    if ($scope.minutesRemaining < 0) {
                        $scope.hoursRemaining--;
                        $scope.minutesRemaining = 59;
                    }

                    $scope.currentScore = (($scope.hoursRemaining * 3600) + ($scope.minutesRemaining * 60) + ($scope.secondsRemaining)) * $scope.difficulty;

                    if ($scope.secondsRemaining === 0 && $scope.minutesRemaining === 0 && $scope.hoursRemaining === 0) {
                        $interval.cancel($scope.timer);
                    }
                }, 1000);
            });

            $rootScope.$on("GetSourceFilesReplyMessage", function (event, data) {
                InformationService.sourceFiles = [];
                for (var file in data.SourceFiles) {
                    InformationService.sourceFiles[file] = data.SourceFiles[file];
                }
            });

            $rootScope.$on("CompileReplyMessage", function (event, data) {
                InformationService.lastCompileResult = data.Result;
                InformationService.isCompiling = false;
            });

            var fadeIn;
            var fadeOut;

            $rootScope.$on("TeamActionReplyMessage", function (event, data) {
                InformationService.teamActions.push(data.Action);
                if (angular.isDefined(fadeOut)) {
                    $interval.cancel(fadeOut);
                }

                document.getElementById("newsFeedContent").style.opacity = 1;

                fadeOut = $interval(function () {
                    var opacity = document.getElementById("newsFeedContent").style.opacity;
                    if (opacity <= 0) {
                        $interval.cancel(fadeOut);
                        $scope.startFadeIn(data);
                    }
                    opacity -= 0.05;
                    document.getElementById("newsFeedContent").style.opacity = opacity;
                }, 10);
            });

            $rootScope.$on("GetUserTestsReplyMessage", function (event, data) {
                console.log(data);
                for (var i = 0; i < data.UserTests.length; i++) {
                    InformationService.userTests.push(data.UserTests[i]);
                }
            });

            $rootScope.$on("UserTestsReplyMessage", function (event, data) {
                InformationService.lastTestsResult = data.Result;
                InformationService.isTesting = false;
            });

            $scope.startFadeIn = function (data) {
                if (angular.isDefined(fadeIn)) {
                    $interval.cancel(fadeIn);
                }
                document.getElementById("newsFeedContent").innerHTML = data.Action;
                fadeIn = $interval(function () {
                    var opacity = Number(document.getElementById("newsFeedContent").style.opacity);
                    if (opacity === 1) {
                        $interval.cancel(fadeIn);
                    }
                    opacity += 0.05;
                    document.getElementById("newsFeedContent").style.opacity = opacity;
                }, 10);
            }

            $scope.displayWithLeadingZero = function (number) {
                if (number < 10) {
                    return "0" + number;
                }
                return number;
            }

            $scope.showAccountPage = function () {
                $location.path('/account');
            }

            $scope.logout = function () {
                localStorage.removeItem("userInformation");
                window.location.href = "LoginPage.html";
            }

            SocketService.sendMessage({MessageType: 'GetUserTestsRequestMessage'});
        });