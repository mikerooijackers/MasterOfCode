angular.module('competitorLoginApp').controller('registerController', function ($scope, LoginResources) {


    $scope.register = function () {
        if ($scope.password !== $scope.passwordRepeat) {
            document.getElementById('registerOutput').innerHTML = 'Passwords do not match. Please try again.';
            document.getElementById('registerOutput').style.color = 'red';
            return;
        }
        
        var RegisterMessage = {
            email: $scope.email,
            fullname: $scope.fullname,
            password: $scope.password,
            privilege: 1,
            activationCode: $scope.activationCode,
            telephone: $scope.telephone,
            company: $scope.company
        };
        
        var registerRequest = new LoginResources.registerResource(RegisterMessage);
        registerRequest.$save(function (responseObject) {
            document.getElementById('registerOutput').innerHTML = 'Registration successful!';
            document.getElementById('registerOutput').style.color = 'green';
        });
    }
});