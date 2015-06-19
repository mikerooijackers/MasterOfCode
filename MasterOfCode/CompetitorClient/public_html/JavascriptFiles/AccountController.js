angular.module('competitorClientApp').controller('accountController', function ($scope, InformationService, SocketService, RestResources) {
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
    
    $scope.sendCreateTeamRequest = function() {
        var initiator = InformationService.user.email;
        var teamName = document.getElementById("teamName").value;
        var members = [];
        var memberInputs = document.getElementsByClassName("memberMail");
        for (var i = 0; i < memberInputs.length; i++) {
            members.push(memberInputs[i].value);
        }
        
        var createTeamMessage = {
            teamName: teamName,
            initiator: initiator,
            members: members
        };
        
        var createTeamRequest = new RestResources.createTeamResource(createTeamMessage);
        createTeamRequest.$save(function(responseObject) {
            console.log(responseObject);
        });
    }
});