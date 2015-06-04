angular.module('competitorClientApp').controller('testingController', function ($scope) {
    $scope.message = "Testing controller";
    $scope.showOutput = function (test, output) {
        var testOutputTable = document.getElementById('testOutput' + test);
        testOutputTable.style.marginTop = 0;
        var testOutputField = document.getElementById('outputField' + test);
        testOutputField.innerHTML = output;
        testOutputField.style.height = "50px";
    }
    
    $scope.selectAll = function() {
        var checkboxes = document.getElementsByClassName("testCheckBox");
        for (var i = 0; i < checkboxes.length; i++) {
            checkboxes[i].checked = $scope.allTests;
        }
    }
});