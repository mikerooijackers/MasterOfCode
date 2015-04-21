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
public class StartCompetitionMessage extends BaseMessage {
    
    public static final String MessageType = "startCompetitionMessage";
    private int numberOfRounds;
    private String competitionName;
    private Long startTime;
    
    public StartCompetitionMessage() {
        
    }
    
    public StartCompetitionMessage(Long competitionId, int numberOfRounds, String competitionName, Long startTime) {
        super(competitionId);
        this.numberOfRounds = numberOfRounds;
        this.competitionName = competitionName;
        this.startTime = startTime;
    }

    /**
     * @return the numberOfRounds
     */
    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    /**
     * @param numberOfRounds the numberOfRounds to set
     */
    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    /**
     * @return the competitionName
     */
    public String getCompetitionName() {
        return competitionName;
    }

    /**
     * @param competitionName the competitionName to set
     */
    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    /**
     * @return the startTime
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
    
    public static StartCompetitionMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        
        Long jsonCompetitionId = (Long) obj.get("competitionId");
        int jsonNumberOfRounds = (int) obj.get("numberOfRounds");
        String jsonCompetitionName = obj.get("competitionName").toString();
        Long jsonStartTime = (Long) obj.get("startTime");
        
        return new StartCompetitionMessage(jsonCompetitionId, jsonNumberOfRounds, jsonCompetitionName, jsonStartTime);
    }
}
