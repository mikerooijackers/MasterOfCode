/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import com.mycompany.utilitiesmodule.ZipUtils;
import com.mycompany.workspacemanagementmoduleb.WorkspaceService;
import com.mycompany.workspacemanagementmoduleb.utils.FileUtils;
import java.io.File;
import mocjms.messages.main.OperationDrivenReplyMessage;
import mocjms.messages.main.OperationDrivenRequestMessage;
import mocjms.messages.reply.ExtractAssignmentToWorkspacesReplyMessage;

/**
 *
 * @author Gebruiker
 */
public class ExtractAssignmentToWorkspacesRequestMessage extends OperationDrivenRequestMessage {

    private byte[] blob;
    private Long roundId;
    private Long competitionId;
    
    /**
     *
     * @param assignmentId
     * @param roundId
     * @param competitionId
     */
    public ExtractAssignmentToWorkspacesRequestMessage(Long assignmentId, Long roundId, Long competitionId) {
        this.roundId = roundId;
        this.competitionId = competitionId;
        this.prepareBlob(assignmentId);
    }

    /**
     *
     * @return
     */
    public byte[] getBlob() {
        return blob;
    }
    
    private void prepareBlob(Long assignmentId) {
        File assignmentFolder = new File(WorkspaceService.ASSIGNMENTS_PATH + File.separator + assignmentId);
        File[] files = assignmentFolder.listFiles();
        
        for (File file : files) {
            if (FileUtils.checkFileExtension(file, ".zip")) {
                this.blob = ZipUtils.convertFileToByteArray(file);
                break;
            }
        }
    }

    /**
     *
     * @param blob
     */
    public void setBlob(byte[] blob) {
        this.blob = blob;
    }

    /**
     *
     * @return
     */
    public Long getRoundId() {
        return roundId;
    }

    /**
     *
     * @param roundId
     */
    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }

    /**
     *
     * @return
     */
    public Long getCompetitionId() {
        return competitionId;
    }

    /**
     *
     * @param competitionId
     */
    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }
    
    @Override
    public OperationDrivenReplyMessage generateReplyMessage() {
        boolean succes = WorkspaceService.getInstance().extractAssignmentToWorkspaces(competitionId, roundId, blob);
        OperationDrivenReplyMessage message = new ExtractAssignmentToWorkspacesReplyMessage(succes);
        
        return message;
    }
    
}
