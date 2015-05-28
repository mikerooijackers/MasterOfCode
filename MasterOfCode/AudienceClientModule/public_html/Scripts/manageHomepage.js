angular.module('audienceClient')
        .controller('manageHomepageController', function ($scope) {
            
            
            // MOCK DATA!!! ----------------------------------------------------
            
            $scope.round = {number: 3, state: "Playing", timeLeft: "03:24"};

            $scope.teams = [{
                    name: "Team A", rank: 2, score: 2200
                }, {
                    name: "Team B", rank: 3, score: 1800
                }, {
                    name: "Team C", rank: 1, score: 2500
                }, {
                    name: "Team D", rank: 6, score: 1200
                }, {
                    name: "Team E", rank: 4, score: 1700
                }, {
                    name: "Team F", rank: 5, score: 1400
                }],
            
                    $scope.news = [{
                            team: "Team A",
                            message: "did a compile request.",
                            time: "10 seconds ago"
                        }, {
                            team: "Team D",
                            message: "executed user tests.",
                            time: "1 minute ago"
                        }, {
                            team: "Team E",
                            message: "turned in the assignment.",
                            time: "2 minutes ago"
                        }];
            
            // -----------------------------------------------------------------           
            
        });