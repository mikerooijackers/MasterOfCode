/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import com.mycompany.jmslayermodule.ReplyBean;
import com.mycompany.utilitiesmodule.ZipUtils;
import com.mycompany.workspacemanagementmoduleb.WorkspaceService;
import static com.mycompany.workspacemanagementmoduleb.WorkspaceService.ASSIGNMENTS_PATH;
import com.mycompany.workspacemanagementmoduleb.utils.FileUtils;
import java.io.File;
import mocjms.messages.main.CompetitionBaseMessage;
import mocjms.messages.main.OperationDrivenMessage;

/**
 *
 * @author Gebruiker
 */
public class ExtractAssignmentToWorkspacesRequestMessage implements OperationDrivenMessage {

    private byte[] blob;
    private Long roundId;
    private Long competitionId;
    
    public ExtractAssignmentToWorkspacesRequestMessage(Long assignmentId, Long roundId, Long competitionId) {
        this.roundId = roundId;
        this.competitionId = competitionId;
        this.prepareBlob(assignmentId);
    }

    public byte[] getBlob() {
        return blob;
    }
    
    private void prepareBlob(Long assignmentId) {
        File assignmentFolder = new File(ASSIGNMENTS_PATH + File.separator + assignmentId);
        File[] files = assignmentFolder.listFiles();
        
        for (File file : files) {
            if (FileUtils.checkFileExtension(file, ".zip")) {
                this.blob = ZipUtils.convertFileToByteArray(file);
                break;
            }
        }
    }

    public void setBlob(byte[] blob) {
        this.blob = blob;
    }

    public Long getRoundId() {
        return roundId;
    }

    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }
    
    @Override
    public void doWork(ReplyBean replyBean) {
        WorkspaceService.getInstance().extractAssignmentToWorkspaces(competitionId, roundId, blob);
    }
    
}
