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
import mocjms.messages.reply.CompileReplyMessage;

/**
 *
 * @author Gebruiker
 */
public class CompileRequestMessage extends CompetitionBaseMessage implements OperationDrivenMessage {
    
    public CompileRequestMessage() {
    }

    public CompileRequestMessage(Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
    }
    
    @Override
    public void doWork(ReplyBean replyBean) {
        WorkspaceService.getInstance().requestCompile(super.getTeamId(), super.getCompetitionId(), super.getRoundId());
        
        OperationDrivenMessage message = new CompileReplyMessage("TO SPECIFY", super.getTeamId(), super.getRoundId(), super.getCompetitionId());
        replyBean.send(message);
    }
    
}
