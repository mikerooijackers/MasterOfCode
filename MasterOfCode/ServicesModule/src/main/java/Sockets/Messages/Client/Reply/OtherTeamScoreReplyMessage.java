/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Reply;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class OtherTeamScoreReplyMessage extends BaseMessage {
    
    /**
     *
     */
    public static final String messageType = MessageTypes.OtherTeamScoreReplyMessage.toString();
    private String teamName;
    private int teamScore;
    
    /**
     * Constructor
     */
    public OtherTeamScoreReplyMessage(){};
    
    /**
     * Constructor
     * @param competitionId
     * @param teamId
     * @param teamScore
     */
    public OtherTeamScoreReplyMessage(String teamName, int teamScore) {
        this.teamName = teamName;
        this.teamScore = teamScore;
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
    
    /**
     *
     * @param s
     * @return
     */
    public static OtherTeamScoreReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        
        String jsonTeamName = obj.get("TeamName").toString();
        int jsonTeamScore = (int) obj.get("TeamScore");
        
        return new OtherTeamScoreReplyMessage(jsonTeamName, jsonTeamScore);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("TeamName", this.teamName);
        obj.put("TeamScore", this.teamScore);
        return obj.toString();
    }

    /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
