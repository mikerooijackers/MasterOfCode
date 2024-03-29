/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import com.mycompany.workspacemanagementmoduleb.WorkspaceService;
import mocjms.messages.main.CompetitionBasedOperationDrivenReplyMessage;
import mocjms.messages.main.CompetitionBasedOperationDrivenRequestMessage;
import mocjms.messages.reply.EditSourceCodeReplyMessage;

/**
 *
 * @author Gebruiker
 */
public class EditSourceCodeRequestMessage extends CompetitionBasedOperationDrivenRequestMessage {
    private String classPath;
    private String newCode;

    /**
     *
     */
    public EditSourceCodeRequestMessage() {
    }

    /**
     *
     * @param teamId
     * @param roundId
     * @param competitionId
     */
    public EditSourceCodeRequestMessage(Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
    }

    /**
     *
     * @param classPath
     * @param newCode
     */
    public EditSourceCodeRequestMessage(String classPath, String newCode) {
        this.classPath = classPath;
        this.newCode = newCode;
    }

    /**
     *
     * @param classPath
     * @param newCode
     * @param teamId
     * @param roundId
     * @param competitionId
     */
    public EditSourceCodeRequestMessage(String classPath, String newCode, Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
        this.classPath = classPath;
        this.newCode = newCode;
    }

    /**
     *
     * @return
     */
    public String getClassPath() {
        return classPath;
    }

    /**
     *
     * @param classPath
     */
    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    /**
     *
     * @return
     */
    public String getNewCode() {
        return newCode;
    }

    /**
     *
     * @param newCode
     */
    public void setNewCode(String newCode) {
        this.newCode = newCode;
    }
    
    @Override
    public CompetitionBasedOperationDrivenReplyMessage generateReplyMessage() {
        boolean success = WorkspaceService.getInstance().editSourceCode(classPath, newCode);
        
        CompetitionBasedOperationDrivenReplyMessage message = new EditSourceCodeReplyMessage(success, super.getTeamId(), super.getRoundId(), super.getCompetitionId());
        return message;
    }
}
