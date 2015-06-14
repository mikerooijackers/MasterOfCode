angular.module('competitorLoginApp').controller('registerController', function ($scope, LoginResources) {


    $scope.register = function () {
        var RegisterMessage = {
            email: $scope.email,
            fullname: $scope.fullname,
            password: $scope.password,
            privilege: 1,
            activationCode: $scope.activationCode
        };
        
        var registerRequest = new LoginResources.registerResource(RegisterMessage);
        registerRequest.$save(function (responseObject) {
            console.log(responseObject);
        });
    }
});