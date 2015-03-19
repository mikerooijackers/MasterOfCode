package Domein;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Team {

    @ManyToOne(cascade=CascadeType.ALL, targetEntity = MOCUser.class)
    private Collection<MOCUser> members;
    private int score;
    private String workspacePath;
    
    @ManyToOne
    private Competition competition;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team() {
    }

    public Collection<MOCUser> getMembers() {
            return this.members;
    }

    public void setMembers(Collection<MOCUser> members) {
            this.members = members;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getWorkspacePath() {
        return workspacePath;
    }

    public void setWorkspacePath(String workspacePath) {
        this.workspacePath = workspacePath;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

        
}