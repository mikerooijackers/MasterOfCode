angular.module('competitorClientApp', ['ngRoute', 'ngWebsocket'])

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
                    });
        })

        .controller('mainController', function ($scope, SocketService, $rootScope, InformationService, $interval) {
            $scope.message = 'This is the main controller';
            SocketService.start("ws://localhost:35785/ServicesModule/contestantSocket");
            var NewSessionConnectionMessage = {MessageType: "NewSessionConnectionMessage", Username: "Noor"};
            SocketService.sendMessage(NewSessionConnectionMessage);

            $scope.hoursRemaining = 3;
            $scope.minutesRemaining = 0;
            $scope.secondsRemaining = 10;

            $rootScope.$on("HintReplyMessage", function (event, data) {
                InformationService.hints.push(data.HintMessage);
            });

            $rootScope.$on("StartRoundReplyMessage", function (event, data) {
                InformationService.assignCreatorName = data.AssignCreatorName;
                InformationService.assignCreatorCompany = data.AssignCreatorCompany;
                InformationService.assignCreatorWeb = data.AssignCreatorWeb;

                InformationService.assignName = data.AssignName;
                InformationService.assignDescriptionCompetitors = data.AssignDescriptionCompetitors;
                InformationService.assignDescriptionSpectators = data.AssignDescriptionSpectators;
            });

            $rootScope.$on("GetSourceFilesReplyMessage", function (event, data) {
                InformationService.sourceFiles = [];
                for (var file in data.SourceFiles) {
                    InformationService.sourceFiles[file] = data.SourceFiles[file];
                }
            });

            $rootScope.$on("CompileReplyMessage", function (event, data) {
                InformationService.lastCompileResult = data.Result;
            });

            var fadeIn;
            var fadeOut;

            $rootScope.$on("TeamActionReplyMessage", function (event, data) {
                if (angular.isDefined(fadeOut)) {
                    $interval.cancel(fadeOut);
                }
                
                document.getElementById("newsFeedContent").style.opacity = 1;
                
                fadeOut = $interval(function () {
                    var opacity = document.getElementById("newsFeedContent").style.opacity;
                    console.log(opacity);
                    if (opacity <= 0) {
                        $interval.cancel(fadeOut);
                        $scope.startFadeIn(data);
                    }
                    opacity -= 0.05;
                    document.getElementById("newsFeedContent").style.opacity = opacity;
                }, 10);
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

            $scope.debug = function () {
                var mess = {MessageType: "DebugMessage"};
                SocketService.sendMessage(mess);
            }

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

                if ($scope.secondsRemaining === 0 && $scope.minutesRemaining === 0 && $scope.hoursRemaining === 0) {
                    $interval.cancel($scope.timer);
                }
            }, 1000);

            $scope.displayWithLeadingZero = function (number) {
                if (number < 10) {
                    return "0" + number;
                }
                return number;
            }
        });