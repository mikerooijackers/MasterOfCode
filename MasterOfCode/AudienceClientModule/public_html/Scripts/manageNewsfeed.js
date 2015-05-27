angular.module('audienceClient')
        .controller('manageNewsfeed', function ($scope) {

            $scope.checkAll = function () {
                if ($scope.selectedAll) {
                    $scope.selectedAll = false;
                } else {
                    $scope.selectedAll = true;
                }
                angular.forEach($scope.Items, function (item) {
                    item.Selected = $scope.selectedAll;
                });
            };

            // MOCK DATA!!! ----------------------------------------------------
            $scope.Items = [{
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
            
            $scope.News = [{
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
