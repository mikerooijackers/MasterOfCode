package Sockets.Messages.Reply;

import domein.MOCUser;
import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class NewParticipantReplyMessage extends BaseMessage {

    public static final String messageType = MessageTypes.NewParticipantReplyMessage.toString();

    private MOCUser user;
    
    public NewParticipantReplyMessage() {
    }
    
    public NewParticipantReplyMessage(MOCUser user) {
        this.user = user;
    }

    public static NewParticipantReplyMessage decodeJSON(String s) {
        
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        return new NewParticipantReplyMessage();
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
//        obj.put("User", this.user.toJSONString());
        obj.put("Fullname", this.user.getFullName());
//        obj.put("Id", this.user.getId());
        obj.put("Email", this.user.getEmail());
        obj.put("MessageType", this.messageType);
        return obj.toJSONString();
    }

}
