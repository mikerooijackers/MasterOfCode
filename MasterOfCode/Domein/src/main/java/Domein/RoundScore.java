/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domein;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author mikerooijackers
 */
@Entity
@NamedQueries ({
    @NamedQuery(name = "GetRoundScore", query = "select r FROM RoundScore r WHERE r.round.id = :roundId")   
})
public class RoundScore implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    private Round round;
    
    @ManyToOne
    private Team team;
    
    private int score;

    /**
     * Get id from RoundScore
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * Set id from RoundScore
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get Round
     * @return
     */
    public Round getRound() {
        return round;
    }

    /**
     * Set Round
     * @param round
     */
    public void setRound(Round round) {
        this.round = round;
    }

    /**
     * Get Team
     * @return
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Set Team
     * @param team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * Get Score
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * Set Score
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }
}
