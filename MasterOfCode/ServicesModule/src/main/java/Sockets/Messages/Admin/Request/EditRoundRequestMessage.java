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
public class EditRoundRequestMessage extends BaseMessage {
    
    /**
     *
     */
    public static final String messageType = MessageTypes.EditRoundRequestMessage.toString();
    
    private Long competitionId;
    private Long roundId;
    private String assignmentPath;
    private Long roundTimeInSeconds;
    private int difficulty;
    private String spectatorDescription;
    private String participantDescription;
    
    /**
     *
     */
    public EditRoundRequestMessage(){
    }
    
    /**
     *
     * @param competitionId
     * @param roundId
     * @param assignmentPath
     * @param roundTimeInSeconds
     * @param difficulty
     * @param spectatorDescription
     * @param participantDescription
     */
    public EditRoundRequestMessage(Long competitionId, Long roundId, String assignmentPath, Long roundTimeInSeconds, int difficulty, String spectatorDescription, String participantDescription) {
        this.competitionId = competitionId;
        this.roundId = roundId;
        this.assignmentPath = assignmentPath;
        this.roundTimeInSeconds = roundTimeInSeconds;
        this.difficulty = difficulty;
        this.spectatorDescription = spectatorDescription;
        this.participantDescription = participantDescription;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static EditRoundRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonCompetitionId = (Long) obj.get("CompetitionId");
        Long jsonRoundId = (Long) obj.get("RoundId");
        String jsonAssignmentPath = obj.get("AssignmentPath").toString();
        Long jsonRoundTimeInSeconds = (Long) obj.get("RoundTimeInSeconds");
        int jsonDifficulty = (int) obj.get("Difficulty");
        String jsonSpectatorDescription = obj.get("SpectatorDescription").toString();
        String jsonParticipantDescription = obj.get("ParticipantDescription").toString();
        return new EditRoundRequestMessage(jsonCompetitionId, jsonRoundId, jsonAssignmentPath, jsonRoundTimeInSeconds, jsonDifficulty, jsonSpectatorDescription, jsonParticipantDescription);
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
        obj.put("RoundId", this.roundId);
        obj.put("AssignmentPath", this.assignmentPath);
        obj.put("RoundTimeInSeconds", this.roundTimeInSeconds);
        obj.put("Difficulty", this.difficulty);
        obj.put("SpectatorDescription", this.spectatorDescription);
        obj.put("ParticipantDescription", this.participantDescription);
        return obj.toJSONString();
    }
    
}
