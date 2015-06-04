angular.module('competitorClientApp').controller('editorController', function ($scope, SocketService, $rootScope, InformationService, $compile) {
    $scope.fileName = "";

    $scope.editorOption = {
        lineNumbers: true
    };
    var javaEditor = CodeMirror.fromTextArea(document.getElementById("myTextArea"), {
        lineNumbers: true,
        theme: "neat",
        matchBrackets: true,
        mode: "text/x-java",
        foldGutter: {
            rangeFinder: new CodeMirror.fold.combine(CodeMirror.fold.brace, CodeMirror.fold.comment)
        },
        gutters: ["CodeMirror-linenumbers", "CodeMirror-foldgutter"],
        extraKeys: {"F11": function (cm) {
                cm.setOption("fullScreen", !cm.getOption("fullScreen"));
            }
        }
    });
    javaEditor.setSize(null, 495);

    SocketService.sendMessage({MessageType: "GetSourceFilesRequestMessage", TeamId: 1});

    $scope.sourceReplyOnFunction = $rootScope.$on('GetSourceFilesReplyMessage', function (event, data) {
        var sourceFileTable = document.getElementById('sourceFileTable');
        var firstRow = sourceFileTable.insertRow();
        firstRow.className = "tableHeader";
        var headerRow = firstRow.insertCell();
        headerRow.innerHTML = "<b>Source files:<b>";

        for (var file in InformationService.sourceFiles) {
            var row = sourceFileTable.insertRow();
            row.className = "javaclass";
            var cell = row.insertCell();
            cell.innerHTML = "<a ng-click=\"changeCode('" + file + "')\">" + file + "</a>";
            $compile(cell)($scope);
        }
    });

    $scope.$on('$destroy', function () {
        $scope.sourceReplyOnFunction();
    });

    $scope.changeCode = function (fileName) {
        $scope.fileName = fileName;
        javaEditor.getDoc().setValue(InformationService.sourceFiles[fileName]);
    };

    $scope.save = function () {
        InformationService.sourceFiles[$scope.fileName] = javaEditor.getDoc().getValue();
    }
});