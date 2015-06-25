angular.module('competitorClientApp').controller('testingController', function ($scope, $rootScope, InformationService, SocketService, $location) {
    if (!InformationService.user.team || InformationService.roundBusy === false) {
        $location.path('/account');
    }
    $scope.message = "Testing controller";
    $scope.showOutput = function (test, output) {
        var testOutputTable = document.getElementById('testOutput' + test);
        testOutputTable.style.marginTop = 0;
        var testOutputField = document.getElementById('outputField' + test);
        testOutputField.innerHTML = output;
        testOutputField.style.height = "50px";
    }

    $scope.selectAll = function () {
        var checkboxes = document.getElementsByClassName("testCheckBox");
        for (var i = 0; i < checkboxes.length; i++) {
            checkboxes[i].checked = $scope.allTests;
        }
    }

    $scope.userTestsResultListener = $rootScope.$on("UserTestsReplyMessage", function (event, data) {
        var result = InformationService.lastTestsResult.replace(/\n/g, '<br>');
        result = result.replace('BUILD SUCCESS', "<font color='green'><b>BUILD SUCCESS</b></font>");
        result = result.replace('BUILD FAILED', "<font color='red'><b>BUILD FAILED</b></font>");
        result = result.replace('BUILD FAILURE', "<font color='red'><b>BUILD FAILURE</b></font>");
        document.getElementById('testsResult').innerHTML = result;
        document.getElementById("runTests").disabled = false;
        InformationService.isTesting = false;
    });

    var result = InformationService.lastTestsResult.replace(/\n/g, '<br>');
    result = result.replace('BUILD SUCCESS', "<font color='green'><b>BUILD SUCCESS</b></font>");
    result = result.replace('BUILD FAILED', "<font color='red'><b>BUILD FAILED</b></font>");
    result = result.replace('BUILD FAILURE', "<font color='red'><b>BUILD FAILURE</b></font>");
    document.getElementById('testsResult').innerHTML = result;
    
    document.getElementById("runTests").disabled = InformationService.isTesting;

    $scope.showTests = function () {
        var testsContainer = document.getElementById("testsContainer");
        testsContainer.innerHTML = "";
        var tests = "";

        for (var i = 0; i < InformationService.userTests.length; i++) {
            tests += "<div class='row' id='" + InformationService.userTests[i].TestName + "'>";
            tests += "<div class='col-md-4'></div>";
            tests += "<div class='col-md-7'>";
            tests += "<input class='testCheckBox' type='checkbox' name='tests' value='" + InformationService.userTests[i].TestName + "'>Test this<br>";
            tests += "</div>";
            tests += "<div class='col-md-1'></div>";
            tests += "</div>";

            tests += "<div class='row'>";
            tests += "<div class='col-md-4'></div>";
            tests += "<div class='col-md-7' id='testUnknown'>";
            tests += "<p class='testTitle'>" + InformationService.userTests[i].TestName + "</p>";
            tests += "<p class='testDescription'>" + InformationService.userTests[i].Description + "</p>";
            tests += "</div>";
            tests += "<div class='col-md-1'></div>";
            tests += "</div>";
        }

        testsContainer.innerHTML = tests;
    }

    $scope.requestTests = function () {
        document.getElementById("runTests").disabled = true;
        InformationService.isTesting = true;
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
            SocketService.sendMessage({MessageType: 'UserTestsRequestMessage', TestNames: testsToRun, TeamId: InformationService.user.team.id});
        }
    }

    $scope.showTests();
});