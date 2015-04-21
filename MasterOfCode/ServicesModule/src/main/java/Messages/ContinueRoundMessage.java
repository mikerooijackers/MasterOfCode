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
public class ContinueRoundMessage extends BaseMessage {
    
    public static final String MessageType = "continueRoundMessage";
    
    public ContinueRoundMessage(){}
    
    public ContinueRoundMessage(Long competitionId) {
        super(competitionId);
    }
    
    public static ContinueRoundMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonCompetitionId = (Long) obj.get("competitionId");
        return new ContinueRoundMessage(jsonCompetitionId);
    }
}
