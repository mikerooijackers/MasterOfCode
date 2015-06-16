angular.module('audienceClient')
        .controller('manageScoresController', function ($scope, $rootScope) {

            var round = null;
    
            $scope.scores = null;
            
            $rootScope.$on("CompetitionInfoReplyMessage", function (event, data) {

            });

            // MOCK DATA!!! ----------------------------------------------------   

            $scope.operators = [{
                    name: "Round 1", completed: "true",
                    scores: [
                        {
                            rank: 1,
                            team: "Team C",
                            score: 600
                        }, {
                            rank: 2,
                            team: "Team A",
                            score: 550
                        }, {
                            rank: 3,
                            team: "Team B",
                            score: 400
                        }
                    ]
                }, {
                    name: "Round 2", completed: "true",
                    scores: [
                        {
                            rank: 1,
                            team: "Team A",
                            score: 1800
                        }, {
                            rank: 2,
                            team: "Team C",
                            score: 1600
                        }, {
                            rank: 3,
                            team: "Team B",
                            score: 1300
                        }
                    ]
                }, {
                    name: "Round 3", completed: "true",
                    scores: [
                        {
                            rank: 1,
                            team: "Team C",
                            score: 2500
                        }, {
                            rank: 2,
                            team: "Team A",
                            score: 2200
                        }, {
                            rank: 3,
                            team: "Team B",
                            score: 1800
                        }
                    ]
                }, {
                    name: "Round 4", completed: "false",
                }, {
                    name: "Round 5", completed: "false",
                }, {
                    name: "Round 6", completed: "false",
                }];

            // -----------------------------------------------------------------

            $scope.init = function (round) {
                if (round === null || typeof (round) === 'undefined')
                {
                    round = "Round 1";
                }
                for (var i = 0; i < $scope.operators.length; i++) {
                    if ($scope.operators[i].name === round) {

                        $scope.name = $scope.operators[i].name;                                      
                        $scope.scores = $scope.operators[i].scores;
                    }
                }
            };

            $scope.init(round);

        });