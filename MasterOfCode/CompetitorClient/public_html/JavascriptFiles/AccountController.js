angular.module('competitorClientApp').controller('accountController', function ($scope, InformationService, SocketService) {
    $scope.selectedPage = "myInformation";
    $scope.user = InformationService.user;
    
    $scope.sendChangePasswordRequest = function() {
        var oldPassword = document.getElementById("oldPassword").value;
        var newPassword = document.getElementById("newPassword").value;
        var newPasswordAgain = document.getElementById("newPasswordAgain").value;
        
        if (newPassword !== newPasswordAgain) {
            alert("New passwords do not match. Please try again.");
        }
        
        var changePasswordMessage = {
            MessageType: "ChangePasswordRequestMessage",
            UserId: InformationService.user.id,
            OldPassword: oldPassword,
            NewPassword: newPassword
        };
        
        SocketService.sendMessage(changePasswordMessage);
    };
});