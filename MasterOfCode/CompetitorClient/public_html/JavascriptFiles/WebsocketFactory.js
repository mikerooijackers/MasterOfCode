angular.module('competitorClientApp')
        .factory('SocketService', function ($rootScope) {
            var ws;
            return {
                start: function (url) {
                    ws = new WebSocket(url);
                    ws.onopen = function (event) {
                        console.log("Connection opened");
                    };
                    ws.onclose = function (event) {
                    };
                    ws.onmessage = function (event) {
                        var Message = JSON.parse(event.data);
                        console.log("Message received");
                        $rootScope.$broadcast(Message.MessageType, Message);
                    };
                },
                sendMessage: function (message) {
                    waitForSocketConnection(ws, function () {
                        console.log("message sent!!!");
                        ws.send(JSON.stringify(message));
                    });
                }
            }

            function waitForSocketConnection(socket, callback) {
                setTimeout(
                        function () {
                            if (socket.readyState === 1) {
                                console.log("Connection is made")
                                if (callback !== null) {
                                    callback();
                                }
                                return;

                            } else {
                                console.log("wait for connection...")
                                waitForSocketConnection(socket, callback);
                            }

                        }, 5); // wait 5 milisecond for the connection...
            }
        });

