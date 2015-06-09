angular.module('competitorClientApp').controller('compileController', function ($scope, SocketService, $rootScope, InformationService) {
    $scope.message = "Controller succesfully linked";
    $scope.lastCompileMessage = InformationService.lastCompileResult;
    
    $scope.compile = function() {
        var message = {};
        message.TeamId = 0;
        message.MessageType = "CompileRequestMessage";
        SocketService.sendMessage(message);
    };
    
    $scope.compileReplyListener = $rootScope.$on("CompileReplyMessage", function(event, data) {
        var result = InformationService.lastCompileResult;
        result = result.replace(/\n/g,'<br>');
        result = result.replace('BUILD SUCCESS', "<font color='green'><b>BUILD SUCCESS</b></font>");
        result = result.replace('BUILD FAILED', "<font color='red'><b>BUILD FAILED</b></font>");
        document.getElementById("compileResultContainer").innerHTML = result;
    });
    
    $scope.$on("$destroy", function() {
        $scope.compileReplyListener();
    });
});