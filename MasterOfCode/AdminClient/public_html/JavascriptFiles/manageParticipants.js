angular.module('adminClient')
        .controller('manageParticipantsController', function ($scope, $rootScope, websocketService) {
            var DebugMessage = {
                MessageType: "DebugMessage"
            };
            
            $rootScope.$on("HintReplyMessage", function(event, data){
               console.log("Received message: " + data.HintMessage); 
            });
            
            websocketService.sendMessage(DebugMessage);
        });