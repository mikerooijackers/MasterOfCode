package Domein;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

@Entity
public class Team implements JSONAware, Serializable {

    @Transient
    private Collection<MOCUser> members;
    private int score;
    private String workspacePath;
    private String teamName;

    @ManyToOne
    private Competition competition;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * get Team ID
     *
     * @return long
     */
    public long getId() {
        return id;
    }

    /**
     * set Team ID
     *
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
     *
     * @return collection
     */
    public Collection<MOCUser> getMembers() {
        return this.members;
    }

    /**
     * Set Members
     *
     * @param members
     */
    public void setMembers(Collection<MOCUser> members) {
        this.members = members;
    }

    /**
     * Get Score
     *
     * @return int
     */
    public int getScore() {
        return score;
    }

    /**
     * Set Score
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Get WorkspacePath
     *
     * @return string
     */
    public String getWorkspacePath() {
        return workspacePath;
    }

    /**
     * Set WorkspacePath
     *
     * @param workspacePath
     */
    public void setWorkspacePath(String workspacePath) {
        this.workspacePath = workspacePath;
    }

    /**
     * Get Competition
     *
     * @return Competition
     */
    public Competition getCompetition() {
        return competition;
    }

    /**
     * Set Competition
     *
     * @param competition
     */
    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
    
        /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("Members", this.members);
        obj.put("Score", this.score);
        obj.put("Workspacepath", this.workspacePath);
        obj.put("Competition", this.competition);
        obj.put("Id", this.id);
        obj.put("TeamName", this.teamName);
        return obj.toJSONString();
    }

}
