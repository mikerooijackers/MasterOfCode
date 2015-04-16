/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import Domein.Competition;
import Domein.Round;
import Domein.Team;

/**
 *
 * @author May
 */
public class CompileRequest {
    private Team team;
    private Round round;
    private Competition competition;
    
    public CompileRequest() {
        
    }
    
    public CompileRequest(Team team, Round round, Competition competition)
    {
        this.team = team;
        this.round = round;
        this.competition = competition;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
