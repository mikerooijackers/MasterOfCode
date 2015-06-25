/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.main;

import java.io.Serializable;

/**
 *
 * @author Gebruiker
 */
public class CompetitionBaseMessage implements Serializable {
    private Long teamId;
    private Long roundId;
    private Long competitionId;

    /**
     *
     */
    public CompetitionBaseMessage() {
    }

    /**
     *
     * @param teamId
     * @param roundId
     * @param competitionId
     */
    public CompetitionBaseMessage(Long teamId, Long roundId, Long competitionId) {
        this.teamId = teamId;
        this.roundId = roundId;
        this.competitionId = competitionId;
    }

    /**
     *
     * @return
     */
    public Long getTeamId() {
        return teamId;
    }

    /**
     *
     * @param teamId
     */
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    /**
     *
     * @return
     */
    public Long getRoundId() {
        return roundId;
    }

    /**
     *
     * @param roundId
     */
    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }

    /**
     *
     * @return
     */
    public Long getCompetitionId() {
        return competitionId;
    }

    /**
     *
     * @param competitionId
     */
    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }
}
