angular.module('competitorClientApp').controller('editorController', function ($scope, SocketService, $rootScope, InformationService, $compile, $location) {
    if (!InformationService.user.team || InformationService.roundBusy === false) {
        $location.path('/account');
    }
    $scope.fileName = "";

    $scope.editorOption = {
        lineNumbers: true
    };
    $scope.javaEditor = CodeMirror.fromTextArea(document.getElementById("myTextArea"), {
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
    $scope.javaEditor.setSize(null, 495);

    SocketService.sendMessage({MessageType: "GetSourceFilesRequestMessage", TeamId: InformationService.user.team.id});

    $scope.sourceReplyOnFunction = $rootScope.$on('GetSourceFilesReplyMessage', function (event, data) {
        var sourceFileTable = document.getElementById('sourceFileTable');
        var firstRow = sourceFileTable.insertRow();
        firstRow.className = "tableHeader";
        var headerRow = firstRow.insertCell();
        headerRow.innerHTML = "<b>Source files:<b>";

        var readOnlyFileTable = document.getElementById('readOnlyFileTable');
        var rFirstRow = readOnlyFileTable.insertRow();
        rFirstRow.className = "tableHeader";
        var rHeaderRow = rFirstRow.insertCell();
        rHeaderRow.innerHTML = "<b>Read-only files:</b>";

        for (var file in InformationService.sourceFiles) {
            if (InformationService.sourceFiles[file].Editable) {
                var row = sourceFileTable.insertRow();
            } else {
                var row = readOnlyFileTable.insertRow();
            }
            row.className = "javaclass";
            var cell = row.insertCell();
            cell.innerHTML = "<a ng-click=\"changeCode(" + file + ", " + InformationService.sourceFiles[file].Editable + ")\">" + InformationService.sourceFiles[file].Path.substring(InformationService.sourceFiles[file].Path.lastIndexOf("\\") + 1) + "</a>";
            $compile(cell)($scope);
        }
    });

    $scope.$on('$destroy', function () {
        $scope.sourceReplyOnFunction();
    });

    $scope.changeCode = function (fileName, editable) {
        console.log(fileName);
        $scope.fileName = fileName;
        $scope.javaEditor.getDoc().setValue(InformationService.sourceFiles[fileName].Content);
        $scope.javaEditor.setOption("readOnly", !editable);
        document.getElementById("saveButton").disabled = !editable;
    };

    $scope.save = function () {
        InformationService.sourceFiles[$scope.fileName].Content = $scope.javaEditor.getDoc().getValue();
        SocketService.sendMessage({MessageType: "EditSourceCodeRequestMessage", NewSourceCode: $scope.javaEditor.getDoc().getValue(), SourceCodeFile: InformationService.sourceFiles[$scope.fileName].Path, RoundId: 1, TeamId: InformationService.user.team.id});
    }
});