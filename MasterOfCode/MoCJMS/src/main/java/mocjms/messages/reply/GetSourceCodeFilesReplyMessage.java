/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.reply;

import Domein.SourceCode;
import java.util.ArrayList;
import java.util.List;
import mocjms.messages.main.CompetitionBasedOperationDrivenReplyMessage;

/**
 *
 * @author Gebruiker
 */
public class GetSourceCodeFilesReplyMessage extends CompetitionBasedOperationDrivenReplyMessage {

    private List<SourceCode> listSourceCode;

    public GetSourceCodeFilesReplyMessage() {
        this.listSourceCode = new ArrayList<>();
    }

    public GetSourceCodeFilesReplyMessage(Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
        this.listSourceCode = new ArrayList<>();
    }

    public GetSourceCodeFilesReplyMessage(List<SourceCode> listSourceCode) {
        this.listSourceCode = listSourceCode;
    }

    public GetSourceCodeFilesReplyMessage(List<SourceCode> listSourceCode, Long teamId, Long roundId, Long competitionId) {
        super(teamId, roundId, competitionId);
        this.listSourceCode = listSourceCode;
    }

    public List<SourceCode> getListSourceCode() {
        return listSourceCode;
    }

    public void setListSourceCode(List<SourceCode> listSourceCode) {
        this.listSourceCode = listSourceCode;
    }
}
