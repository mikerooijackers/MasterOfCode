/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import com.mycompany.workspacemanagementmoduleb.WorkspaceService;
import mocjms.messages.main.CompetitionBasedOperationDrivenReplyMessage;
import mocjms.messages.main.CompetitionBasedOperationDrivenRequestMessage;
import mocjms.messages.reply.CompileReplyMessage;

/**
 *
 * @author Gebruiker
 */
public class CompileRequestMessage extends CompetitionBasedOperationDrivenRequestMessage {
    
    public CompileRequestMessage() {
    }

    public CompileRequestMessage(Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
    }
    
    @Override
    public CompetitionBasedOperationDrivenReplyMessage generateReplyMessage() {
        String result = WorkspaceService.getInstance().requestCompile(super.getTeamId(), super.getCompetitionId(), super.getRoundId());
        
        CompetitionBasedOperationDrivenReplyMessage message = new CompileReplyMessage(result, super.getTeamId(), super.getRoundId(), super.getCompetitionId());
        return message;
    }
    
}
