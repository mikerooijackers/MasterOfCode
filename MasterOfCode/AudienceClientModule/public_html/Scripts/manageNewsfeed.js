angular.module('audienceClient')
        .controller('manageNewsfeedController', function ($scope) {

            $scope.checkAll = function () {
                if ($scope.selectedAll) {
                    $scope.selectedAll = false;
                } else {
                    $scope.selectedAll = true;
                }
                angular.forEach($scope.items, function (item) {
                    item.Selected = $scope.selectedAll;
                });
            };

            // MOCK DATA!!! ----------------------------------------------------
            $scope.items = [{
                    name: "Team A"
                }, {
                    name: "Team B"
                }, {
                    name: "Team C"
                }, {
                    name: "Team D"
                }, {
                    name: "Team E"
                }, {
                    name: "Team F"
                }];
            
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
