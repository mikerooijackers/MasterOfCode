angular.module('adminClient')
        .controller('manageTeamController', function ($scope, $rootScope, $compile, websocketService, InformationService) {

            // Variables

            var GetParticipantsRequestMessage = {
                MessageType: "GetParticipantsRequestMessage"
            };

            var GetTeamsRequestMessage = {
                MessageType: "GetTeamsRequestMessage"
            };

            // On initialization

//            websocketService.sendMessage(GetParticipantsRequestMessage);
            websocketService.sendMessage(GetTeamsRequestMessage);

            // On receiving messages

            $scope.GetParticipantsReplyListener = $rootScope.$on("GetParticipantsReplyMessage", function (event, data) {
                console.log("Received GetParticipantsReplyMessage in manageTeamController");
            });

            $scope.GetTeamsReplyListener = $rootScope.$on("GetAllTeamsReplyMessage ", function (event, data) {
                console.log("Received GetAllTeamsReplyMessage in manageTeamController");
            });

            $scope.$on("$destroy", function () {
                $scope.GetParticipantsReplyListener();
                $scope.GetTeamsReplyListener();
            });

            // Scope methods

            $scope.fillTeamsTables = function () {
                var approvedTeamsTable = document.getElementById("approvedTeamsTable");
                var nonApprovedTeamsTable = document.getElementById("nonApprovedTeamsTable");
                approvedTeamsTable.innerHTML = "";
                nonApprovedTeamsTable.innerHTML = "";
            };
        });