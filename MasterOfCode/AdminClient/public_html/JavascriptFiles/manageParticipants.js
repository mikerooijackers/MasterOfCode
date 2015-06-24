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
                    content.innerHTML = "<a ng-click=\"fillParticipantInfoTable('" + participant + "')\">" + InformationService.participants[participant].FullName + "</a>";
                }
                
                participantTable.className = "borderedTable";
                $compile(participantTable)($scope);
            };

            $scope.fillParticipantInfoTable = function (email) {
                var participantInfoTable = document.getElementById("participantInfoTable");
                participantInfoTable.innerHTML = "";
                participantInfoTable.innerHTML += "<b>Full name:</b> " + InformationService.participants[email].FullName + "<br>";
                participantInfoTable.innerHTML += "<b>E-mail:</b> " + InformationService.participants[email].Email + "<br>";
                participantInfoTable.innerHTML += "<b>Company:</b> " + InformationService.participants[email].Company + "<br>";
                participantInfoTable.innerHTML += "<b>Telephone:</b> " + InformationService.participants[email].TelephoneNumber + "<br>";
                participantInfoTable.innerHTML += "<b>Team:</b> " + InformationService.participants[email].Team + "<br>";
            };

            // On initialization

            $scope.fillParticipantsTable();
        });