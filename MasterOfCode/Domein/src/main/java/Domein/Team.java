package Domein;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

/**
 *
 * @author mikerooijackers
 */
@Entity
@NamedQueries ({
    @NamedQuery(name = "AllTeams", query = "select t FROM Team t")
})
public class Team implements Serializable {

    @Transient
    private Collection<MOCUser> members;
    private int score;
    private String teamName;
    private String serverName;
    
    @ManyToOne
    private Competition competition;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * get Team ID
     * @return long
     */
    public long getId() {
        return id;
    }

    /**
     * set Team ID
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Constructor
     */
    public Team() {
    }

    /**
     * get Members
     * @return collection
     */
    public Collection<MOCUser> getMembers() {
            return this.members;
    }

    /**
     * Set Members
     * @param members
     */
    public void setMembers(Collection<MOCUser> members) {
            this.members = members;
    }

    /**
     * Get Score
     * @return int
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

    /**
     * Get Competition
     * @return Competition
     */
    public Competition getCompetition() {
        return competition;
    }

    /**
     * Set Competition
     * @param competition 
     */
    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    /**
     * get serverName
     * @return
     */
    public String getServerName() {
        return serverName;
    }

    /**
     * set ServerName
     * @param serverName
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    /**
     * get number of Members
     * @return
     */
    public int getNumberofMembers() {
        return this.members.size();
    };

    /**
     * get TeamName
     * @return
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Set Name
     * @param teamName
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}