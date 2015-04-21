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
public class UnfreezeRoundMessage extends BaseMessage {
    
    public static final String MessageType = "unfreezeRoundMessage";
    
    public UnfreezeRoundMessage(){}
    
    public UnfreezeRoundMessage(Long competitionId) {
        super(competitionId);
    }
    
    public static UnfreezeRoundMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonCompetitionId = (Long) obj.get("competitionId");
        return new UnfreezeRoundMessage(jsonCompetitionId);
    }
}
