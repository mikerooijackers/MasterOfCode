package Sockets.Messages;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.Client.Reply.GetUserTestsReplyMessage;
import java.util.HashMap;
import java.util.Map;
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
        Map<String, String> descriptions = new HashMap<String, String>();
        descriptions.put("Test1", "This is the first test.");
        descriptions.put("Test2", "This is the seconds test.");
        descriptions.put("Test3", "This is the third test.");
        GetUserTestsReplyMessage mess = new GetUserTestsReplyMessage(descriptions);
        communicationBean.sendMessageToCompetitor("Noor", mess);
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        return obj.toJSONString();
    }

}