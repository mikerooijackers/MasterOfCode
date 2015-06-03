package Sockets.Messages;

import Domein.MOCUser;
import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.Reply.GetParticipantsReplyMessage;
import Sockets.Messages.Reply.NewParticipantReplyMessage;
import java.util.ArrayList;
import java.util.List;
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
        List<MOCUser> userList = new ArrayList<MOCUser>();
        userList.add(new MOCUser("John", "password", "email", "John Schipper", null, null));
        userList.add(new MOCUser("Jordi", "password", "email", "Jordi Knol", null, null));
        userList.add(new MOCUser("Maaike", "password", "email", "Maaike Jansen", null, null));
        
        GetParticipantsReplyMessage message = new GetParticipantsReplyMessage(userList);
        communicationBean.sendMessageToAdmin("Jordi", message);
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        return obj.toJSONString();
    }
    
}
