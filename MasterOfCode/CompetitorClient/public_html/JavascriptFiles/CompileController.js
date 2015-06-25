angular.module('competitorClientApp').controller('compileController', function ($scope, SocketService, $rootScope, InformationService, $location) {
    if (!InformationService.user.team || InformationService.roundBusy === false) {
        $location.path('/account');
    }
    
    document.getElementById("compileButton").disabled = InformationService.isCompiling;

    $scope.message = "Controller succesfully linked";
    $scope.lastCompileMessage = InformationService.lastCompileResult;
    $scope.lastCompileMessage = $scope.lastCompileMessage.replace(/\n/g, '<br>');
    $scope.lastCompileMessage = $scope.lastCompileMessage.replace('BUILD SUCCESS', "<font color='green'><b>BUILD SUCCESS</b></font>");
    $scope.lastCompileMessage = $scope.lastCompileMessage.replace('BUILD FAILED', "<font color='red'><b>BUILD FAILED</b></font>");
    document.getElementById("compileResultContainer").innerHTML = $scope.lastCompileMessage;

    $scope.compile = function () {
        document.getElementById("compileButton").disabled = true;
        InformationService.isCompiling = true;
        var message = {};
        message.TeamId = InformationService.user.team.id;
        message.MessageType = "CompileRequestMessage";
        SocketService.sendMessage(message);
    };

    $scope.compileReplyListener = $rootScope.$on("CompileReplyMessage", function (event, data) {
        var result = InformationService.lastCompileResult;
        result = result.replace(/\n/g, '<br>');
        result = result.replace('BUILD SUCCESS', "<font color='green'><b>BUILD SUCCESS</b></font>");
        result = result.replace('BUILD FAILED', "<font color='red'><b>BUILD FAILED</b></font>");
        result = result.replace('BUILD FAILURE', "<font color='red'><b>BUILD FAILURE</b></font>");
        document.getElementById("compileResultContainer").innerHTML = result;
        document.getElementById("compileButton").disabled = false;
    });

    $scope.$on("$destroy", function () {
        $scope.compileReplyListener();
    });
});