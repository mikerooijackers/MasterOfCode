angular.module('competitorClientApp').controller('javadocController', function ($scope, InformationService, $location) {
    if (!InformationService.user.team || InformationService.roundBusy === false) {
        $location.path('/account');
    }
    $scope.message = "Javadoc controller";
    $scope.pdfLink = "https://portal.fhict.nl/IS/S6/Lesmateriaal/PTSE6-Master%20of%20Code-Studiewijzer.pdf";
});