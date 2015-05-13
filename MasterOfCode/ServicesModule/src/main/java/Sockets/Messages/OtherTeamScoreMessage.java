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
public class OtherTeamScoreMessage extends BaseMessage {
    
    public static final MessageTypes messageType = MessageTypes.OtherTeamScoreMessage;
    private Long teamId;
    private int teamScore;
    
    public OtherTeamScoreMessage(){};
    
    public OtherTeamScoreMessage(Long competitionId, Long teamId, int teamScore) {
        this.teamId = teamId;
        this.teamScore = teamScore;
    }

    /**
     * @return the teamId
     */
    public Long getTeamId() {
        return teamId;
    }

    /**
     * @param teamId the teamId to set
     */
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    /**
     * @return the teamScore
     */
    public int getTeamScore() {
        return teamScore;
    }

    /**
     * @param teamScore the teamScore to set
     */
    public void setTeamScore(int teamScore) {
        this.teamScore = teamScore;
    }
    
    public static OtherTeamScoreMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        
        Long jsonCompetitionId = (Long) obj.get("competitionId");
        Long jsonTeamId = (Long) obj.get("teamID");
        int jsonTeamScore = (int) obj.get("teamScore");
        
        return new OtherTeamScoreMessage(jsonCompetitionId, jsonTeamId, jsonTeamScore);
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
