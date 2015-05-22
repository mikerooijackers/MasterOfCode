/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MessageUtils;

import Enumerations.MessageTypes;
import Sockets.Messages.BaseMessage;
import Sockets.Messages.Client.Reply.CompileReplyMessage;
import Sockets.Messages.DebugMessage;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class MessageDecoder implements Decoder.Text<BaseMessage> {

    @Override
    public BaseMessage decode(String s) throws DecodeException {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        String messageTypeString = obj.get("MessageType").toString();
        MessageTypes mt = MessageTypes.valueOf(messageTypeString);
        switch (mt) {
            case CompileReplyMessage:
                return CompileReplyMessage.decodeJSON(s);
            case DebugMessage:
                return DebugMessage.decodeJSON(s);
        }
        return null;
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig config) {
        System.out.println("Decoder initiated");
    }

    @Override
    public void destroy() {
        System.out.println("Decoder destroyed");
    }

}
