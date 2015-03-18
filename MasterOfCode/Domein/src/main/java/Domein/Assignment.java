package Domein;

//@id

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//@name
//@organisation
//@weblink
//@linkLogo
//@nameAssignment
//@descriptionPublic
//@descriptionTeam
//@sourceCode
@Entity
public class Assignment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String path;
    
    @ManyToMany(cascade=CascadeType.ALL)
    private Collection<Competition> competitions;

    public Assignment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Collection<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Collection<Competition> competitions) {
        this.competitions = competitions;
    }
    
    
}