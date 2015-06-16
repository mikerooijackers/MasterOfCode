angular.module('competitorLoginApp').controller('loginController', function ($scope, LoginResources) {

    $scope.login = function () {
        var LoginMessage = {
            email: $scope.email,
            password: $scope.password
        };
        
        var loginRequest = new LoginResources.loginResource(LoginMessage);
        loginRequest.$save(function(responseObject) {
            console.log(responseObject);
            if (!responseObject.email && !responseObject.password) {
                document.getElementById('loginError').style.display = 'block';
                return;
            }
            localStorage.setItem("userInformation", JSON.stringify(responseObject));
            window.location.href = "index.html";
        });
    };
});