angular.module('audienceClient')
        .controller('manageScores', function ($scope) {
            
            
            
            
            
            
            
            
            
            // MOCK DATA!!! ----------------------------------------------------
            $scope.operators = [{
                    name: "Round 1"
                }, {
                    name: "Round 2"
                }, {
                    name: "Round 3"
                }, {
                    name: "Round 4"
                }, {
                    name: "Round 5"
                }, {
                    name: "Round 6"
                }];
            
            $scope.Scores = [{
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
            }];
            
            // -----------------------------------------------------------------
            
        });