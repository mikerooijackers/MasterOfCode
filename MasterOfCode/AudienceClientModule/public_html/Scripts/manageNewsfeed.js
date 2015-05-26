angular.module('audienceClient')
        .controller('manageNewsfeed', function ($scope) {

//            $scope.checkAll = function () {
//                var checks = document.querySelectorAll('#filter input[type="checkbox"]');
//                for (var i = 0; i < checks.length; i++) {
//                    var check = checks[i];
//                    if (check.disabled) {
//                        check.checked = true;
//                    }
//                }
//            }
//
//            $scope.uncheckAll = function () {
//                var checks = document.querySelectorAll('#filter input[type="checkbox"]');
//                for (var i = 0; i < checks.length; i++) {
//                    var check = checks[i];
//                    if (!check.disabled) {
//                        check.checked = false;
//                    }
//                }
//            };

            // MOCK DATA!!!
            $scope.Items = [{
                    name: "Team A"
                }, {
                    name: "Team B"
                }, {
                    name: "Team C"
                }];

            $scope.checkAll = function () {
                if ($scope.selectedAll) {
                    $scope.selectedAll = true;
                } else {
                    $scope.selectedAll = false;
                }
                angular.forEach($scope.Items, function (item) {
                    item.Selected = $scope.selectedAll;
                });
            }
        });
