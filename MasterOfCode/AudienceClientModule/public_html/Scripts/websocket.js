/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Create a websocket
var socket = new WebSocket("ws://");

// Check for a websocket 
$(document).ready(function () {
    if (!("WebSocket" in window)) {
        $('#chatLog, input, button, #examples').fadeOut("fast");
        $('<p>Oh no, you need a browser that supports WebSockets.</p>').appendTo('#container');
    } else {

        //The user has WebSockets
        connect();

        function connect() {
            //the connect function code is below
            try {

                var socket;
                var host = "ws://";
                var socket = new WebSocket(host);

                message('<p class="event">Socket Status: ' + socket.readyState);

                socket.onopen = function () {
                    message('<p class="event">Socket Status: ' + socket.readyState + ' (open)');
                };

                socket.onmessage = function (msg) {
                    message('<p class="message">Received: ' + msg.data);
                };

                socket.onclose = function () {
                    message('<p class="event">Socket Status: ' + socket.readyState + ' (Closed)');
                };

            } catch (exception) {
                message('<p>Error' + exception);
            }
        }
    }
});

