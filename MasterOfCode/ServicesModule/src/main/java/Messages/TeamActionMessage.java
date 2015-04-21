/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Messages;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class TeamActionMessage extends BaseMessage {
    
    public static final String MessageType = "teamActionMessage";
    
    private String action;
    
    public TeamActionMessage(){
        
    }
    
    public TeamActionMessage(String action) {
        this.action = action;
    }
    
    public static TeamActionMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        String jsonAction = obj.get("action").toString();
        return new TeamActionMessage(jsonAction);
    }
}
