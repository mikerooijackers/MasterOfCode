/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Reply;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import Timer.TimerData;
import Timer.TimerType;
import java.util.Calendar;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class StartCompetitionReplyMessage extends BaseMessage {
    
    /**
     *
     */
    public static final String messageType = MessageTypes.StartCompetitionReplyMessage.toString();
    private int numberOfRounds;
    private String competitionName;
    private Calendar startTime;
    private String description;
        
    
    /**
     * Constructor
     */
    public StartCompetitionReplyMessage() {
        
    }
    
    /**
     *
     * @param numberOfRounds
     * @param competitionName
     * @param startTime
     * @param description
     */
    public StartCompetitionReplyMessage(int numberOfRounds, String competitionName, Calendar startTime, String description) {
        this.numberOfRounds = numberOfRounds;
        this.competitionName = competitionName;
        this.startTime = startTime;
        this.description = description;
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
    public Calendar getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static StartCompetitionReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        
        int jsonNumberOfRounds = (int) obj.get("NumberOfRounds");
        String jsonCompetitionName = obj.get("CompetitionName").toString();
        Calendar jsonStartTime = (Calendar) obj.get("StartTime");
        String jsonDescription = obj.get("Description").toString();
        
        return new StartCompetitionReplyMessage(jsonNumberOfRounds, jsonCompetitionName, jsonStartTime, jsonDescription);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        System.out.println("In the doAction of the StartCompetitionReplyMessage");
        
        TimerData timerData = new TimerData(TimerType.CompetitionCountDownTimer);
        communicationBean.startTimer(timerData, 10);
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("NumberOfRounds", this.numberOfRounds);
        obj.put("CompetitionName", this.competitionName);
        obj.put("StartTime", this.startTime);
        obj.put("Description", this.description);
        return obj.toString();
    }
}
