angular.module('competitorClientApp').controller('turninController', function ($scope, SocketService) {
    $scope.message = "Turn in conroller";
    
    $scope.turnIn = function() {
        var dialog = confirm("Are you sure you want to hand in your assignment?");
        
        if (dialog == true) {
            SocketService.sendMessage({MessageType: "SubmitRequestMessage", TeamId: 1});
        }
    };
});