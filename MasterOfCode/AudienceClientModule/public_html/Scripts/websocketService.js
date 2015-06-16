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

            };

            function waitForSocketConnection(socket, callback) {
                setTimeout(
                        function () {
                            if (socket.readyState === 1) {
                                console.log("Connection is made");
                                if (callback !== null) {
                                    callback();
                                }
                                return;
                            } else {
                                console.log("wait for connection...");
                                waitForSocketConnection(socket, callback);
                            }
                        }, 5); // wait 5 milisecond for the connection
            }
        });


