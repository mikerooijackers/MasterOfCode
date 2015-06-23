/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import com.mycompany.workspacemanagementmoduleb.WorkspaceService;
import mocjms.messages.main.CompetitionBasedOperationDrivenReplyMessage;
import mocjms.messages.main.CompetitionBasedOperationDrivenRequestMessage;
import mocjms.messages.reply.UserTestReplyMessage;

/**
 *
 * @author Gebruiker
 */
public class UserTestRequestMessage extends CompetitionBasedOperationDrivenRequestMessage {
    /**
     * Name of the tests, seperated by a comma
     */
    private String tests;

    public UserTestRequestMessage() {
    }

    /**
     *
     * @param tests
     * @param teamId
     * @param roundId
     * @param competitionId
     */
    public UserTestRequestMessage(String tests, Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
        this.tests = tests;
    }

    /**
     *
     * @return
     */
    public String getTests() {
        return this.tests;
    }

    /**
     *
     * @param tests
     */
    public void setListTests(String tests) {
        this.tests = tests;
    }

    @Override
    public CompetitionBasedOperationDrivenReplyMessage generateReplyMessage() {
        String result = WorkspaceService.getInstance().runSingleTest(tests, super.getCompetitionId(), super.getTeamId(), super.getRoundId());
        CompetitionBasedOperationDrivenReplyMessage reply = new UserTestReplyMessage(result, super.getTeamId(), super.getRoundId(), super.getCompetitionId());
        
        return reply;
    }
}
