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
public class EditSourceCodeMessage extends BaseMessage {
    
    public static final String messageType = MessageTypes.EditSourceCodeMessage.toString();
    
    private String newSourceCode;
    private String sourceCodeFile;
    private Long roundId;
    private Long teamId;
    
    public EditSourceCodeMessage(){}
    
    public EditSourceCodeMessage(String newSourceCode, String sourceCodeFile, Long roundId, Long teamId) {
        this.newSourceCode = newSourceCode;
        this.sourceCodeFile = sourceCodeFile;
        this.roundId = roundId;
        this.teamId = teamId;
    }

    /**
     * @return the newSourceCode
     */
    public String getNewSourceCode() {
        return newSourceCode;
    }

    /**
     * @param newSourceCode the newSourceCode to set
     */
    public void setNewSourceCode(String newSourceCode) {
        this.newSourceCode = newSourceCode;
    }

    /**
     * @return the sourceCodeFile
     */
    public String getSourceCodeFile() {
        return sourceCodeFile;
    }

    /**
     * @param sourceCodeFile the sourceCodeFile to set
     */
    public void setSourceCodeFile(String sourceCodeFile) {
        this.sourceCodeFile = sourceCodeFile;
    }

    /**
     * @return the roundId
     */
    public Long getRoundId() {
        return roundId;
    }

    /**
     * @param roundId the roundId to set
     */
    public void setRoundId(Long roundId) {
        this.roundId = roundId;
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
    
    public static EditSourceCodeMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonRoundId = (Long) obj.get("roundId");
        Long jsonTeamId = (Long) obj.get("teamId");
        String jsonNewSourceCode = obj.get("newSourceCode").toString();
        String jsonSourceCodeFile = obj.get("sourceCodeFile").toString();
        return new EditSourceCodeMessage(jsonNewSourceCode, jsonSourceCodeFile, jsonRoundId, jsonTeamId);
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("NewSourceCode", this.newSourceCode);
        obj.put("SourceCodeFile", this.sourceCodeFile);
        obj.put("RoundId", this.roundId);
        obj.put("TeamId", this.teamId);
        return obj.toString();
    }
}
