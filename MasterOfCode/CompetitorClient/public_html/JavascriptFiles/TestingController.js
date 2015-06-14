angular.module('competitorClientApp').controller('testingController', function ($scope, $rootScope, InformationService, SocketService) {
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
    
    $scope.userTestReplyListener = $rootScope.$on("GetUserTestsReplyMessage", function (event, data) {
        $scope.showTests();
    });
    
    $scope.$on("$destroy", function() {
        $scope.userTestReplyListener();
    });
    
    $scope.showTests = function() {
        var testsContainer = document.getElementById("testsContainer");
        testsContainer.innerHTML = "";
        var tests = "";
        
        for (var test in InformationService.testDescriptions) {
            tests += "<div class='row' id='" + test + "'>";
            tests += "<div class='col-md-4'></div>";
            tests += "<div class='col-md-7'>";
            tests += "<input class='testCheckBox' type='checkbox' name='tests' value='" + test + "'>Test this<br>";
            tests += "</div>";
            tests += "<div class='col-md-1'></div>";
            tests += "</div>";
            
            tests += "<div class='row'>";
            tests += "<div class='col-md-4'></div>";
            tests += "<div class='col-md-7' id='testUnknown'>";
            tests += "<p class='testTitle'>" + test + "</p>";
            tests += "<p class='testDescription'>" + InformationService.testDescriptions[test] + "</p>";
            tests += "</div>";
            tests += "<div class='col-md-1'></div>";
            tests += "</div>";
        }
        
        testsContainer.innerHTML = tests;
    }
    
    $scope.requestTests = function() {
        var testsToRun = [];
        var checkboxes = document.getElementsByClassName('testCheckBox');
        for (var i = 0; i < checkboxes.length; i++) {
            var checkbox = checkboxes[i];
            if (checkbox.checked) {
                testsToRun.push(checkbox.value);
            }
        }
        if (testsToRun.length === 0) {
            alert("Please select at least 1 test to run!");
        } else {
            SocketService.sendMessage({MessageType: 'UserTestsRequestMessage', TestNames: testsToRun});
        }
    }
    
    $scope.showTests();
    
    SocketService.sendMessage({MessageType: 'GetUserTestsRequestMessage'});
});