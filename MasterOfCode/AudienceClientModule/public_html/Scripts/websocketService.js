angular.module('audienceClient')
        .factory('websocketService', function ($rootScope) {
            var websocket;
            return {
                start: function (url) {
                    websocket = new WebSocket(url);

                    websocket.onopen = function () {
                        
                    };

                    websocket.onclose = function () {
                    };

                    websocket.onmessage = function (evt) {
                        console.log("Message received!!!");
                        var mes = JSON.parse(evt.data);
                        console.log("Received message: " + mes);
                        $rootScope.$broadcast(mes.MessageType, mes);
                    };
                },
                sendMessage: function (message) {
                }
            }
        });