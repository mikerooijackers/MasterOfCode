angular.module('audienceClient')
        .controller('manageNewsfeedController', function ($scope) {


            // MOCK DATA!!! ----------------------------------------------------
            $scope.news = [{
                    message: "Team A did a compile request.",
                    time: "10 seconds ago"
                }, {
                    message: "Team D executed user tests.",
                    time: "1 minute ago"
                }, {
                    message: "Team E turned in the assignment.",
                    time: "2 minutes ago"
                }, {
                    message: "Team A executed user tests.",
                    time: "4 minutes ago"
                }];
        });