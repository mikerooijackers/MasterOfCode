package Sockets.Messages;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import org.json.simple.JSONObject;

public class DebugMessage extends BaseMessage {

    /**
     *
     */
    public static final String messageType = MessageTypes.DebugMessage.toString();

    public static DebugMessage decodeJSON(String s) {
        return new DebugMessage();
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        return obj.toJSONString();
    }
}

