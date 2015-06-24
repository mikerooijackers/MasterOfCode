/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Admin.Request;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mikerooijackers
 */
public class AddRoundToCompetitionRequestMessage extends BaseMessage {

    /**
     *
     */
    public static final String messageType = MessageTypes.AddRoundToCompetitionRequestMessage.toString();

    private Long competitionId;
    private String assignmentPath;
    private Long roundTimeInSeconds;
    private int difficulty;
    private String spectatorDescription;
    private String competitorDescription;

    /**
     *
     */
    public AddRoundToCompetitionRequestMessage() {
    }
    
    /**
     *
     * @param competitionId
     * @param assignmentPath
     * @param roundTimeInSeconds
     * @param difficulty
     * @param spectatorDescription
     * @param competitorDescription
     */
    public AddRoundToCompetitionRequestMessage(Long competitionId, String assignmentPath, Long roundTimeInSeconds, int difficulty, String spectatorDescription, String competitorDescription) {
        this.competitionId = competitionId;
        this.assignmentPath = assignmentPath;
        this.roundTimeInSeconds = roundTimeInSeconds;
        this.difficulty = difficulty;
        this.spectatorDescription = spectatorDescription;
        this.competitorDescription = competitorDescription;
    }

    /**
     *
     * @param s
     * @return
     */
    public static AddRoundToCompetitionRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonCompetitionId = (Long) obj.get("CompetitionId");
        String jsonAssignmentPath = obj.get("AssignmentPath").toString();
        Long jsonRoundTimeInSeconds = (Long) obj.get("RoundTimeInSeconds");
        int jsonDifficulty = (int) obj.get("Difficulty");
        String jsonSpectatorDescription = obj.get("SpectatorDescription").toString();
        String jsonCompetitorDescription = obj.get("CompetitorDescription").toString();
        return new AddRoundToCompetitionRequestMessage(jsonCompetitionId, jsonAssignmentPath, jsonRoundTimeInSeconds, jsonDifficulty, jsonSpectatorDescription, jsonCompetitorDescription);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("CompetitionId", this.competitionId);
        obj.put("AssignmentPath", this.assignmentPath);
        obj.put("RoundTimeInSeconds", this.roundTimeInSeconds);
        obj.put("Difficulty", this.difficulty);
        obj.put("SpectatorDescription", this.spectatorDescription);
        obj.put("CompetitorDescription", this.competitorDescription);
        return obj.toJSONString();
    }

}
