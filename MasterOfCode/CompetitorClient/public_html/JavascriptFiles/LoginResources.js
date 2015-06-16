angular.module('competitorLoginApp')
        .factory('LoginResources', function ($resource) {
            return {
                loginResource: $resource('http://localhost:35785/ServicesModule/api/RestResource/login'),
                registerResource: $resource('http://localhost:35785/ServicesModule/api/RestResource/register')
            };
        });