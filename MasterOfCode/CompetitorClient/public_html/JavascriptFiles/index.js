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

        .controller('mainController', function ($scope, SocketService, $rootScope, InformationService) {
            $scope.message = 'This is the main controller';
            SocketService.start("ws://localhost:35785/ServicesModule/contestantSocket");
            var NewSessionConnectionMessage = {MessageType: "NewSessionConnectionMessage", Username: "Noor"};
            SocketService.sendMessage(NewSessionConnectionMessage);

            $rootScope.$on("HintReplyMessage", function (event, data) {
                InformationService.hints.push(data.HintMessage);
            });
        })

        .controller('homeController', function ($scope, $rootScope, SocketService) {
            $scope.message = 'Home controller';

            $rootScope.$on('StartRoundMessage', function (event, data) {
                var informationString = "Assignment creator: \n";
                informationString += data.AssignCreatorName;
                informationString += "\n\n Hello world";
                document.getElementById('assignmentTextArea').innerHTML = informationString;
            });

            $scope.debug = function () {
                SocketService.sendMessage({MessageType: "DebugMessage"});
            };
        })

        .controller('editorController', function ($scope) {
            $scope.editorOption = {
                lineNumbers: true
            };
            var javaEditor = CodeMirror.fromTextArea(document.getElementById("myTextArea"), {
                lineNumbers: true,
                theme: "neat",
                matchBrackets: true,
                mode: "text/x-java",
                foldGutter: {
                    rangeFinder: new CodeMirror.fold.combine(CodeMirror.fold.brace, CodeMirror.fold.comment)
                },
                gutters: ["CodeMirror-linenumbers", "CodeMirror-foldgutter"],
                extraKeys: {"F11": function (cm) {
                        cm.setOption("fullScreen", !cm.getOption("fullScreen"));
                    }
                }
            });
            javaEditor.setSize(null, 495);
        })

        .controller('compileController', function ($scope) {
            $scope.message = "Controller succesfully linked";
        })

        .controller('javadocController', function ($scope) {
            $scope.message = "Javadoc controller";
            $scope.pdfLink = "https://portal.fhict.nl/IS/S6/Lesmateriaal/PTSE6-Master%20of%20Code-Studiewijzer.pdf";
        })

        .controller('turninController', function ($scope) {
            $scope.message = "Turn in conroller";
        })

        .controller('testingController', function ($scope) {
            $scope.message = "Testing controller";
            $scope.showOutput = function (test, output) {
                var testOutputTable = document.getElementById('testOutput' + test);
                testOutputTable.style.marginTop = 0;
                var testOutputField = document.getElementById('outputField' + test);
                testOutputField.innerHTML = output;
                testOutputField.style.height = "50px";
            }
        });