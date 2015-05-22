/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages;

import Enumerations.MessageTypes;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class NewSessionConnectionMessage extends BaseMessage {
    
    /**
     *
     */
    public static final String messageType = MessageTypes.NewSessionConnectionMessage.toString();
    private String username;
    
    /**
     * Constructor
     */
    public NewSessionConnectionMessage(){};
    
    /**
     * Constructor
     * @param username
     */
    public NewSessionConnectionMessage(String username) {
        this.username = username;
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    public static NewSessionConnectionMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        String jsonUsername;
        jsonUsername = obj.get("Username").toString();
        return new NewSessionConnectionMessage(jsonUsername);
    }
}
