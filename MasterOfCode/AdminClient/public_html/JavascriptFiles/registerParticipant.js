angular.module('adminClient')
        .controller('registerParticipantController', function ($scope, websocketService) {
            
            // Variables
    
            $scope.fullName = "";
            $scope.email = "";
            $scope.company = "";
            $scope.telephoneNumber = "";

            var RegisterMemberRequestMessage = {
                MessageType: "RegisterMemberRequestMessage"
            };

            // Scope methods
            
            $scope.registerParticipant = function () {
                if ($scope.fullName !== null && $scope.email !== null && $scope.company !== null && $scope.telephoneNumber !== null) {
                    RegisterMemberRequestMessage.Name = $scope.fullName;
                    RegisterMemberRequestMessage.Email = $scope.email;
                    RegisterMemberRequestMessage.Organization = $scope.company;
                    RegisterMemberRequestMessage.Phone = $scope.telephoneNumber;
                    
                    console.log("Name: " + $scope.fullName);
                    console.log("Email: " + $scope.email);
                    console.log("Company: " + $scope.company);
                    console.log("Phone: " + $scope.telephoneNumber);
                    
                    websocketService.sendMessage(RegisterMemberRequestMessage);
                }
            };
        });