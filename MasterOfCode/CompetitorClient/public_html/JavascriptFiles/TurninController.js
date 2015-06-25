angular.module('competitorClientApp').controller('turninController', function ($scope, SocketService, InformationService, $location) {
    if (!InformationService.user.team || InformationService.roundBusy === false) {
        $location.path('/account');
    }
    $scope.message = "Turn in conroller";

    $scope.turnIn = function () {
        SocketService.sendMessage({MessageType: "SubmitRequestMessage", TeamId: InformationService.user.team.id});
    };
});