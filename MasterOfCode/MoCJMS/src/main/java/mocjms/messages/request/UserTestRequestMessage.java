/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import java.util.ArrayList;
import java.util.List;
import mocjms.messages.main.CompetitionBaseMessage;
import mocjms.messages.main.OperationDrivenMessage;

/**
 *
 * @author Gebruiker
 */
public class UserTestRequestMessage extends CompetitionBaseMessage implements OperationDrivenMessage {
    private List<String> listTests;

    public UserTestRequestMessage() {
        this.listTests = new ArrayList<>();
    }

    public UserTestRequestMessage(List<String> listTests) {
        this.listTests = listTests;
    }

    public UserTestRequestMessage(Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
        this.listTests = new ArrayList<>();
    }

    public UserTestRequestMessage(List<String> listTests, Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
        this.listTests = listTests;
    }

    public List<String> getListTests() {
        return listTests;
    }

    public void setListTests(List<String> listTests) {
        this.listTests = listTests;
    }

    @Override
    public void doWork() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
