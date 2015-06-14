angular.module('adminClient')
        .controller('manageParticipantsController', function ($scope, $rootScope, $compile, websocketService, InformationService) {
            console.log("Hello world");
            // Variables

            var GetParticipantsRequestMessage = {
                MessageType: "GetParticipantsRequestMessage"
            };

            // On initialization

            websocketService.sendMessage(GetParticipantsRequestMessage);

            // On receiving messages

            $scope.getParticipantsReplyListener = $rootScope.$on("GetParticipantsReplyMessage", function (event, data) {
                console.log("Received GetParticipantsReplyMessage in the manageParticipantsController");
                $scope.fillParticipantsTable();
            });

            $scope.$on("$destroy", function () {
                $scope.getParticipantsReplyListener();
            });

            // Scope methods

            $scope.fillParticipantsTable = function () {
                var participantTable = document.getElementById("participantTable");
                participantTable.innerHTML = "";

                for (var participant in InformationService.participants) {
                    var row = participantTable.insertRow();
                    var content = row.insertCell();
                    content.innerHTML = "<a ng-click=\"fillParticipantInfoTable('" + participant + "')\">" + participant + "</a>";
                }
                participantTable.className = "borderedTable";
                $compile(participantTable)($scope);
            };

            $scope.fillParticipantInfoTable = function (username) {
                var participantInfoTable = document.getElementById("participantInfoTable");
                participantInfoTable.innerHTML = "";
                participantInfoTable.innerHTML += "<b>Username:</b> " + InformationService.participants[username].Username + "<br>";
                participantInfoTable.innerHTML += "<b>Full name:</b> " + InformationService.participants[username].FullName + "<br>";
                participantInfoTable.innerHTML += "<b>E-mail:</b> " + InformationService.participants[username].Email + "<br>";
                participantInfoTable.innerHTML += "<b>Company:</b> " + InformationService.participants[username].Company + "<br>";
                participantInfoTable.innerHTML += "<b>Telephone:</b> " + InformationService.participants[username].TelephoneNumber + "<br>";
                participantInfoTable.innerHTML += "<b>Team:</b> " + InformationService.participants[username].Team + "<br>";
            };

            // On initialization

            $scope.fillParticipantsTable();
        });