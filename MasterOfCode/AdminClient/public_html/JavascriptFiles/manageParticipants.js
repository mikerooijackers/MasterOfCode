angular.module('adminClient')
        .controller('manageParticipantsController', function ($scope, $rootScope, $compile, websocketService, InformationService) {
            var DebugMessage = {
                MessageType: "DebugMessage"
            };

            $rootScope.$on("HintReplyMessage", function (event, data) {
                console.log("Received message: " + data.HintMessage);
            });

            $rootScope.$on("GetParticipantsReplyMessage", function (event, data) {
                $scope.fillParticipantsTable();
                console.log("Hey Ho Lets Go " + InformationService.participants["Jordi"].Username );
            });

            websocketService.sendMessage(DebugMessage);

            $scope.fillParticipantsTable = function () {
                var participantTable = document.getElementById("participantTable");
                participantTable.innerHTML = "";

// Test
                for (var participant in InformationService.participants) {
                    participantTable.innerHTML += "<tr><td><a ng-click=\"fillParticipantInfoTable('" + participant + "')\">" + participant + "</a></td></tr>";
                }
                $compile(participantTable)($scope);
            };

            $scope.fillParticipantsTable();
            $scope.fillParticipantInfoTable = function(username) {
                console.log("HE HO LETS GO");
                var participantInfoTable = document.getElementById("participantInfoTable");
                participantInfoTable.innerHTML = "";
                participantInfoTable.innerHTML += "<b>Username:</b> " + InformationService.participants[username].Username + "<br>";
                participantInfoTable.innerHTML += "<b>Full name:</b> " + InformationService.participants[username].FullName + "<br>";
                participantInfoTable.innerHTML += "<b>E-mail:</b> " + InformationService.participants[username].Email + "<br>";
                participantInfoTable.innerHTML += "<b>Company:</b> " + InformationService.participants[username].Company + "<br>";
                participantInfoTable.innerHTML += "<b>Telephone:</b> " + InformationService.participants[username].TelephoneNumber + "<br>";
                participantInfoTable.innerHTML += "<b>Team:</b> " + InformationService.participants[username].Team + "<br>";
                
                // TODO
                // Missing: company, telephone number, team name
                
            };
        });