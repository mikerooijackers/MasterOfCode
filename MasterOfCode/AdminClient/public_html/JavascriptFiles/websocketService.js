angular.module('adminClient')
        .factory('websocketService', function ($rootScope) {
            var websocket;
            return {
                start: function (url) {
                    websocket = new WebSocket(url);

                    websocket.onopen = function () {
                        console.log("Connection opened!!!");
                    };

                    websocket.onclose = function () {
                    };

                    websocket.onmessage = function (evt) {
                        var message = JSON.parse(evt.data);
                        $rootScope.$broadcast(message.MessageType, message);
                        console.log("Message received: " + message.MessageType + "!!!");
                    };
                },
                sendMessage: function (message) {
                    waitForSocketConnection(websocket, function () {
                        websocket.send(JSON.stringify(message));
                        console.log("Message send: " + message.MessageType + "!!!");
                    });
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
                        }, 5); // wait 5 milisecond for the connection...
            }
        });


