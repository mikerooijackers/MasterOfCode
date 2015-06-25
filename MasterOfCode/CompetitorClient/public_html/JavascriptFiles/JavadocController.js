angular.module('competitorClientApp').controller('javadocController', function ($scope, InformationService, $location) {
    if (!InformationService.user.team || InformationService.roundBusy === false) {
        $location.path('/account');
    }
    $scope.message = "Javadoc controller";
    $scope.pdfLink = "https://docs.oracle.com/javase/specs/jls/se8/jls8.pdf";
});