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
public class PauseRoundMessage extends BaseMessage {
    
    public static final String MessageType = "pauseRoundMessage";
    
    public PauseRoundMessage() {
    }
    
    public static PauseRoundMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        return new PauseRoundMessage();
    }
}
