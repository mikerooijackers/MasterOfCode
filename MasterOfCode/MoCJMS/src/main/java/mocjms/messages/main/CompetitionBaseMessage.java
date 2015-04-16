/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.main;

/**
 *
 * @author Gebruiker
 */
public class CompetitionBaseMessage {
    private Long teamId;
    private Long roundId;
    private Long competitionId;

    public CompetitionBaseMessage() {
    }

    public CompetitionBaseMessage(Long teamId, Long roundId, Long competitionId) {
        this.teamId = teamId;
        this.roundId = roundId;
        this.competitionId = competitionId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
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
}
