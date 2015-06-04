/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import com.mycompany.jmslayermodule.ReplyBean;
import com.mycompany.workspacemanagementmoduleb.WorkspaceService;
import mocjms.messages.main.CompetitionBaseMessage;
import mocjms.messages.main.OperationDrivenMessage;
import mocjms.messages.reply.EditSourceCodeReplyMessage;

/**
 *
 * @author Gebruiker
 */
public class EditSourceCodeRequestMessage extends CompetitionBaseMessage implements OperationDrivenMessage {
    private String classPath;
    private String newCode;

    public EditSourceCodeRequestMessage() {
    }

    public EditSourceCodeRequestMessage(Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
    }

    public EditSourceCodeRequestMessage(String classPath, String newCode) {
        this.classPath = classPath;
        this.newCode = newCode;
    }

    public EditSourceCodeRequestMessage(String classPath, String newCode, Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
        this.classPath = classPath;
        this.newCode = newCode;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public String getNewCode() {
        return newCode;
    }

    public void setNewCode(String newCode) {
        this.newCode = newCode;
    }
    
    @Override
    public void doWork(ReplyBean replyBean) {
        boolean success = WorkspaceService.getInstance().editSourceCode(classPath, newCode);
        
        OperationDrivenMessage message = new EditSourceCodeReplyMessage(success, super.getTeamId(), super.getRoundId(), super.getCompetitionId());
        replyBean.send(message);
    }
}
