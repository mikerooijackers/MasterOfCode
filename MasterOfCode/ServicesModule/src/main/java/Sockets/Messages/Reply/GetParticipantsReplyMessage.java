package Sockets.Messages.Reply;

import Domein.MOCUser;
import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author Jay
 */
public class GetParticipantsReplyMessage extends BaseMessage {

    public static final String messageType = MessageTypes.GetParticipantsReplyMessage.toString();
    
    private List<MOCUser> users;
    
    public GetParticipantsReplyMessage() {
    }
    
    public GetParticipantsReplyMessage(List<MOCUser> users) {
        this.users = users;
    }
    
    public static GetParticipantsReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        List<MOCUser> jsonUsers = (List<MOCUser>)obj.get("Users");
        return new GetParticipantsReplyMessage(jsonUsers);
    }
    
    @Override
    public void doAction(CommunicationBean communicationBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        int userAmount = users.size();
        int index = 0;
        String json = "";
        
        json += "{";
        json += "\"MessageType\": \"" + this.messageType + "\",";
        
        json += "\"Users\" : {";
        
        for (MOCUser user : users) {
            json += "\"" + user.getUsername() + "\" :";
            json += "{";
            json += "\"Username\": \"" + user.getUsername() + "\", ";
            json += "\"FullName\": \"" + user.getFullName() + "\", ";
            json += "\"Email\": \"" + user.getEmail() + "\"";
            json += "}";
            
            if (index != userAmount - 1) {
                json += ", ";
            }
            
            index++;
        }
        
        json += "}";
        json += "}";
        
        return json;
    }
    
}
