angular.module('competitorClientApp').controller('accountController', function ($scope, InformationService) {
    $scope.selectedPage = "myInformation";
    $scope.user = InformationService.user;
});