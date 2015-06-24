angular.module('competitorClientApp')
        .factory('RestResources', function ($resource) {
            return {
                createTeamResource: $resource('http://localhost:35785/ServicesModule/api/RestResource/createteam')
            };
        });