/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages;

import Domein.MOCUser;
import Enumerations.MessageTypes;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class AddMembersToTeamRequestMessage extends BaseMessage {
    
    public static final String messageType = MessageTypes.AddMembersToTeamRequestMessage.toString();
    
    private List<MOCUser> usersToAdd;
    
    public AddMembersToTeamRequestMessage() {
        usersToAdd = new ArrayList<>();
    }
    
    public AddMembersToTeamRequestMessage(List<MOCUser> users) {
        this.usersToAdd = users;
    }
    
    public void addMemberToMessage(MOCUser user) {
        this.getUsersToAdd().add(user);
    }
    
    public static AddMembersToTeamRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        List<MOCUser> jsonUsers = (List<MOCUser>) obj.get("usersToAdd");
        return new AddMembersToTeamRequestMessage(jsonUsers);
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the usersToAdd
     */
    public List<MOCUser> getUsersToAdd() {
        return usersToAdd;
    }

    /**
     * @param usersToAdd the usersToAdd to set
     */
    public void setUsersToAdd(List<MOCUser> usersToAdd) {
        this.usersToAdd = usersToAdd;
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("UsersToAdd", this.usersToAdd);
        return obj.toString();
    }
    
}
