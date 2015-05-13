/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enumerations;

/**
 *
 * @author JordiK
 */
public enum MessageTypes {
    CompileReplyMessage("CompileReplyMessage"),
    CompileRequestMessage("CompileRequestMessage"),
    ContinueRoundMessage("ContinueRoundMessage"),
    EditSourceCodeMessage("EditSourceCodeMessage"),
    FreezeRoundMessage("FreezeRoundMessage"),
    HintMessage("HintMessage"),
    OtherTeamScoreMessage("OtherTeamScoreMessage"),
    PauseRoundMessage("PauseRoundMessage"),
    RunTestsByGroupReplyMessage("RunTestsByGroupReplyMessage"),
    RunTestsByGroupRequestMessage("RunTestsByGroupRequestMessage"),
    RunTestsByNameReplyMessage("RunTestsByNameReplyMessage"),
    RunTestsByNameRequestMessage("RunTestsByNameRequestMessage"),
    StartCompetitionMessage("StartCompetitionMessage"),
    StopCompetitionMessage("StopCompetitionMessage"),
    StartRoundMessage("StartRoundMessage"),
    StopRoundMessage("StopRoundMessage"),
    TeamActionMessage("TeamActionMessage"),
    UnfreezeRoundMessage("UnfreezeRoundMessage"),
    AddMembersToTeamRequestMessage("AddMembersToTeamRequestMessage"),
    CreateTeamRequestMessage("CreateTeamRequestMessage"),
    RemoveMemberFromTeamRequestMessage("RemoveMemberFromTeamRequestMessage"),
    GetSourceFilesRequestMessage("GetSourceFilesRequestMessage");
    
    private String name;
    
    MessageTypes(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
