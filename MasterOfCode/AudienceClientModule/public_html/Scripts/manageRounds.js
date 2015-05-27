angular.module('audienceClient')
        .controller('manageRoundsController', function ($scope) {
            
            
            // MOCK DATA!!! ----------------------------------------------------
            
            $scope.Rounds = [{
                    number: 1,
                    state: "Ended",
                    timeLeft: "00:00"
                }, {
                    number: 2,
                    state: "Ended",
                    timeLeft: "00:00"
                }, {
                    number: 3,
                    state: "Playing",
                    timeLeft: "03:40"
                }, {
                    number: 4,
                    state: "Waiting",
                    timeLeft: "10:00"
            }];
        
            // -----------------------------------------------------------------
            
        });