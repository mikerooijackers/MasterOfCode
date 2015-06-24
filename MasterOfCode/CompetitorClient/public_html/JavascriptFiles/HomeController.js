angular.module('competitorClientApp').controller('homeController', function ($scope, $rootScope, SocketService, InformationService, $location) {
    if (!InformationService.user.team || InformationService.roundBusy === false) {
        $location.path('/account');
    }
    $rootScope.$on('StartRoundMessage', function (event, data) {
        var informationString = "Assignment creator: \n";
        informationString += data.AssignCreatorName;
        informationString += "\n\n Hello world";
        document.getElementById('assignmentTextArea').innerHTML = informationString;
    });

    $scope.informationString = "<b>Assignment creator:</b> " + InformationService.assignCreatorName + "<br>" + "<b>Assignment creator company:</b> " + InformationService.assignCreatorCompany + "<br>" + "<b>Assignment creator website:</b> " + InformationService.assignCreatorWeb + "<br><br>";
    $scope.informationString += "<b>Assignment name:</b> " + InformationService.assignName + "<br>" + "<b>Assignment description:</b> " + InformationService.assignDescriptionCompetitors;
    document.getElementById("assignmentTextArea").innerHTML = $scope.informationString;

    $scope.debug = function () {
        SocketService.sendMessage({MessageType: "DebugMessage"});
    };

    $rootScope.$on('StartRoundReplyMessage', function (event, data) {
        $scope.informationString = "<b>Assignment creator:</b> " + InformationService.assignCreatorName + "<br>" + "<b>Assignment creator company:</b> " + InformationService.assignCreatorCompany + "<br>" + "<b>Assignment creator website:</b> " + InformationService.assignCreatorWeb + "<br><br>";
        $scope.informationString += "<b>Assignment name:</b> " + InformationService.assignName + "<br>" + "<b>Assignment description:</b> " + InformationService.assignDescriptionCompetitors;
        document.getElementById("assignmentTextArea").innerHTML = $scope.informationString;
    });
});