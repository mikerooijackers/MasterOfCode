angular.module('competitorClientApp').controller('hintsController', function ($scope, $rootScope, SocketService, InformationService) {

    console.log("Hints size: " + InformationService.hints.length);

    $scope.debug = function () {
        SocketService.sendMessage({MessageType: "DebugMessage"});
    };

    $scope.hintReplyOnFunction = $rootScope.$on("HintReplyMessage", function (event, data) {
        $scope.fillHintsContainer();
    });

    $scope.fillHintsContainer = function () {
        var hintRowNumber = 0;
        var hintNumber = 1;
        var hintsContainer = document.getElementById('hintsContainer');
        hintsContainer.innerHTML = "";
        for (var i = 0; i < InformationService.hints.length; i++) {
            if (i % 3 === 0) {
                hintRowNumber++;
                hintsContainer.innerHTML += "<div class='row' id='hintRow" + hintRowNumber + "' style='margin-bottom:20px'><div class='col-md-3'></div></div>";
            }
            var hintRow = document.getElementById("hintRow" + hintRowNumber);
            hintRow.innerHTML += "<div class='col-md-3'><table class='hintTable'><tr><th>Hint " + hintNumber + "</th></tr><tr><td>" + InformationService.hints[i] + "</td></tr></table></div>";
            hintNumber++;
        }
    };

    $scope.$on('$destroy', function () {
        $scope.hintReplyOnFunction();
        console.log($rootScope.$$listeners.HintReplyMessage);
    });

    $scope.fillHintsContainer();
})