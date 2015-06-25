/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import com.mycompany.workspacemanagementmoduleb.WorkspaceService;
import mocjms.messages.main.CompetitionBasedOperationDrivenReplyMessage;
import mocjms.messages.main.CompetitionBasedOperationDrivenRequestMessage;
import mocjms.messages.reply.TurninReplyMessage;

/**
 *
 * @author JordiK
 */
public class TurninRequestMessage extends CompetitionBasedOperationDrivenRequestMessage {
    
    private Long score;
    
    public TurninRequestMessage(){}
    
    /**
     * 
     * @param teamId
     * @param roundId
     * @param competitionId 
     */
    public TurninRequestMessage(Long teamId, Long roundId, Long competitionId, Long score) {
        super(teamId, roundId, competitionId);
        this.score = score;
    }

    @Override
    public CompetitionBasedOperationDrivenReplyMessage generateReplyMessage() {
        String compileResult = WorkspaceService.getInstance().requestCompile(super.getTeamId(), super.getCompetitionId(), super.getRoundId());
        if (compileResult.contains("BUILD FAILURE") || compileResult.contains("BUILD FAILED")) {
            return new TurninReplyMessage(super.getTeamId(), super.getRoundId(), super.getCompetitionId(), false, score);
        }
        
        String testsResult = WorkspaceService.getInstance().runTestGroup("System", super.getCompetitionId(), super.getTeamId(), super.getRoundId());
        if (testsResult.contains("BUILD FAILURE") || testsResult.contains("BUILD FAILED")) {
            return new TurninReplyMessage(super.getTeamId(), super.getRoundId(), super.getCompetitionId(), false, score);
        }
        
        return new TurninReplyMessage(super.getTeamId(), super.getRoundId(), super.getCompetitionId(), true, score);
    }

    /**
     * @return the score
     */
    public Long getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Long score) {
        this.score = score;
    }
    
}
