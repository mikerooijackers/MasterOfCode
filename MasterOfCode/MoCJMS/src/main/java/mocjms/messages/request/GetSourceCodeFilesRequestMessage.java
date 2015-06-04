/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import Domein.AnnotationData;
import Domein.SourceCode;
import com.mycompany.annotations.Editable;
import com.mycompany.annotations.ReadOnly;
import com.mycompany.jmslayermodule.ReplyBean;
import com.mycompany.workspacemanagementmoduleb.WorkspaceService;
import static com.mycompany.workspacemanagementmoduleb.WorkspaceService.ASSIGNMENTS_PATH;
import com.mycompany.workspacemanagementmoduleb.utils.ReflectionUtils;
import java.io.File;
import java.util.List;
import mocjms.messages.main.CompetitionBaseMessage;
import mocjms.messages.main.OperationDrivenMessage;
import mocjms.messages.reply.GetSourceCodeFilesReplyMessage;

/**
 *
 * @author Gebruiker
 */
public class GetSourceCodeFilesRequestMessage extends CompetitionBaseMessage implements OperationDrivenMessage {

    private List<AnnotationData> annotationData;
    
    public GetSourceCodeFilesRequestMessage() {
    }

    public GetSourceCodeFilesRequestMessage(Long assignmentId, Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
        this.prepareAnnotationData(assignmentId);
    }
    
    private void prepareAnnotationData(Long assignmentId) {
        String path = ASSIGNMENTS_PATH + File.separator + assignmentId;
        this.annotationData = ReflectionUtils.readAnnotationData(path, ReadOnly.class, Editable.class);
    }
    
    @Override
    public void doWork(ReplyBean replyBean) {
        List<SourceCode> sourceCodeList = WorkspaceService.getInstance().readSourceCode(super.getTeamId(), super.getCompetitionId(), super.getRoundId(), this.annotationData);
        
        GetSourceCodeFilesReplyMessage message = new GetSourceCodeFilesReplyMessage(sourceCodeList, super.getTeamId(), super.getRoundId(), super.getCompetitionId());
        replyBean.send(message);
    }
    
}
