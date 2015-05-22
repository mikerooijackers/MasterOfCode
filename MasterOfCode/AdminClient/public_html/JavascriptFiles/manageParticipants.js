angular.module('adminClient')
        .controller('manageParticipantsController', function ($scope, websocketService) {
            var DebugMessage = {
                MessageType: "DebugMessage"
            };
            websocketService.sendMessage(DebugMessage);
        });