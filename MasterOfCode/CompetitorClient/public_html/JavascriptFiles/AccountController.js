angular.module('competitorClientApp').controller('accountController', function ($scope, InformationService, SocketService, RestResources, $http) {
    $scope.selectedPage = "myInformation";
    $scope.user = InformationService.user;

    $scope.sendChangePasswordRequest = function () {
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

    $scope.sendCreateTeamRequest = function () {
        var initiator = InformationService.user.email;
        var teamName = document.getElementById("teamName").value;
        if (teamName === "") {
            document.getElementById("errorField").innerHTML = "You must enter a team name!";
            return;
        }
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
        createTeamRequest.$save(function (responseObject) {
            InformationService.user.privilege = "INITIATOR";
            InformationService.user.team = responseObject;
            $scope.teamName = InformationService.user.team.teamName;
            $scope.getTeamMembers();
            $scope.setTeamPage();
            SocketService.start("ws://localhost:35785/ServicesModule/contestantSocket");
            var NewSessionConnectionMessage = {MessageType: "NewUserSessionConnectionMessage", TeamId: InformationService.user.team.id};
            SocketService.sendMessage(NewSessionConnectionMessage);
        });
    };

    $scope.setTeamPage = function () {
        $scope.selectedPage = (InformationService.user.team) ? "myTeamInfo" : "createMyTeam";
    };

    $scope.getTeamMembers = function () {
        var link = "http://localhost:35785/ServicesModule/api/RestResource/getteammembers/" + InformationService.user.team.id;
        $http.get(link)
                .success(function (response) {
                    InformationService.user.team.members = response;
                    $scope.members = response;
                });
    };

    $scope.addAnotherMember = function () {
        document.getElementById("emailAdresses").innerHTML += "<div class='form-group'>" +
                "<label class='col-md-4 control-label' for='memberEmail'>Member email:</label>" +
                "<div class='col-md-7'>" +
                "<input type='email' class='form-control memberMail' id='memberEmail' ng-model='memberEmail1' placeholder='Email' />" +
                "</div>" +
                "</div>";
    }

    if (InformationService.user.team) {
        $scope.teamName = InformationService.user.team.teamName;
        $scope.getTeamMembers();
    }
});