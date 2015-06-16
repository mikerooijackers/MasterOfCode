angular.module('audienceClient')
        .controller('manageTeamsController', function ($scope) {
             
            var teamName = null;        
                    
            $scope.name = null;
            $scope.members = null;
            $scope.message = null;
            $scope.time = null;
            $scope.score = null;
            $scope.rank = null;
                        
            // MOCK DATA!! -----------------------------------------------------
            
            $scope.operators = [{
                    name: "Team A", rank: 2, score: 2200,
                    members: [
                        {name: "Abby"},
                        {name: "Johnny"},
                        {name: "Kyle"}
                    ], 
                    message: "executed user tests", time: "13:15"
                }, {
                    name: "Team B", rank: 3, score: 1800,
                    members: [
                        {name: "Edward"},
                        {name: "Tim"}
                    ]
                }, {
                    name: "Team C", rank: 1, score: 2500, 
                    members: [
                        {name: "April"},
                        {name: "Mark"},
                        {name: "Dean"}
                    ]
                }, {
                    name: "Team D", rank: 6, score: 1200, 
                    members: [
                        {name: "Sarah"}
                    ]
                }, {
                    name: "Team E", rank: 4, score: 1700, 
                    members: [
                        {name: "May"}
                    ]
                }, {
                    name: "Team F", rank: 5, score: 1400, 
                    members: [
                        {name: "Simon"},
                        {name: "Kent"}
                    ]
                }];
            
            // -----------------------------------------------------------------

            $scope.init = function (teamName) {
                if (teamName === null || typeof(teamName) === 'undefined')
                {
                    teamName = $scope.operators[0].name;
                }              
                for (var i = 0; i < $scope.operators.length; i++) {
                    if ($scope.operators[i].name === teamName) {

                        $scope.name = $scope.operators[i].name;                                      
                        $scope.members = $scope.operators[i].members;
                        $scope.message = $scope.operators[i].message;
                        $scope.time = $scope.operators[i].time;
                        $scope.score = $scope.operators[i].score;
                        $scope.rank = $scope.operators[i].rank;
                    }
                }
            };         
            $scope.init(teamName);
        });


