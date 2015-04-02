package Domein;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author mikerooijackers
 */
@Entity
public class Assignment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String path;

    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Competition> competitions;

    /**
     * Constructor Assignment
     */
    public Assignment() {
    }

    /**
     * get ID of a Assignment
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * set ID of a Assignment
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get path
     *
     * @return String
     */
    public String getPath() {
        return path;
    }

    /**
     * set path
     *
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * get Competitions
     *
     * @return Collection of Competition
     */
    public Collection<Competition> getCompetitions() {
        return competitions;
    }

    /**
     * set competitions
     *
     * @param competitions
     */
    public void setCompetitions(Collection<Competition> competitions) {
        this.competitions = competitions;
    }

}
