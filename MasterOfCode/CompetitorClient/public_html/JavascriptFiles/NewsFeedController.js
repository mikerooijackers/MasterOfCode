angular.module('competitorClientApp').controller('newsFeedController', function ($scope, $rootScope, InformationService) {
    
    $scope.fillTable = function() {
        var newsFeedTable = document.getElementById("newsFeedTable");
        newsFeedTable.innerHTML = "";
        
        for (var i = 0; i < InformationService.teamActions.length; i++) {
            var row = newsFeedTable.insertRow();
            var cell = row.insertCell();
            cell.innerHTML = InformationService.teamActions[i];
        }
    }
    
    $scope.teamActionListener = $rootScope.$on("TeamActionReplyMessage", function(event,data) {
        $scope.fillTable();
    });
    
    $scope.$on("$destroy", function() {
        $scope.teamActionListener();
    });
    
    $scope.fillTable();
});