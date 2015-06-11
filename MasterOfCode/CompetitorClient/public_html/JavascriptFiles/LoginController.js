angular.module('competitorLoginApp').controller('loginController', function ($scope) {
    
    $scope.login = function() {
        console.log($scope.username + " " + $scope.password);
    };
});