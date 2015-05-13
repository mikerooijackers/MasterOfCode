/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Reply;

import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class OtherTeamScoreReplyMessage extends BaseMessage {
    
    public static final String MessageType = "otherTeamScoreMessage";
    private Long teamId;
    private int teamScore;
    
    public OtherTeamScoreReplyMessage(){};
    
    public OtherTeamScoreReplyMessage(Long competitionId, Long teamId, int teamScore) {
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
    
    public static OtherTeamScoreReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        
        Long jsonCompetitionId = (Long) obj.get("competitionId");
        Long jsonTeamId = (Long) obj.get("teamID");
        int jsonTeamScore = (int) obj.get("teamScore");
        
        return new OtherTeamScoreReplyMessage(jsonCompetitionId, jsonTeamId, jsonTeamScore);
    }
}