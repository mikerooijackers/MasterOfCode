/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Admin.Request;

import Enumerations.MessageTypes;
import Sockets.Messages.BaseMessage;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mikerooijackers
 */
public class CreateTeamRequestMessage extends BaseMessage {
    
    public static final String messageType = MessageTypes.CreateTeamRequestMessage.toString();
    
    private String name;
    private String initiator;
    private List<String> usernameMembers;
    
    public CreateTeamRequestMessage(){};
    
    public CreateTeamRequestMessage(String name, String initiator, List<String> usernameMembers) {
        this.name = name;
        this.initiator = initiator;
        this.usernameMembers = usernameMembers;
    }
    
    public static CreateTeamRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        String jsonName = obj.get("Name").toString();
        String jsonInitiator = obj.get("Initiator").toString();
        List<String> jsonUsernameMembers = (List<String>) obj.get("UsernameMembers");
        return new CreateTeamRequestMessage(jsonName, jsonInitiator, jsonUsernameMembers);
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("Name", this.name);
        obj.put("Initiator", this.initiator);
        obj.put("UsernameMembers", this.usernameMembers);
        return obj.toJSONString();
    }
    
}
