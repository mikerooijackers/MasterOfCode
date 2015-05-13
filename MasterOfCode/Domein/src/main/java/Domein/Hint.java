package Domein;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author mikerooijackers
 */
@Entity
public class Hint implements Serializable {

    /**
     * number of a hint
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * name of a hint
     */
    private String name;
    /**
     * description of a hint
     */
    private String description;
    /**
     * delay of a hint
     */
    private int delayInSeconds;

    @ManyToOne
    private Assignment assignment;

    /**
     * Constructor Hint
     */
    public Hint() {
    }

    /**
     * get number of a hint
     *
     * @return long
     */
    public long getId() {
        return id;
    }

    /**
     * get number of a hint
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get delay of a hint in seconds
     *
     * @return int
     */
    public int getDelayInSeconds() {
        return delayInSeconds;
    }

    /**
     * set delay of a hint in seconds
     *
     * @param delayInSeconds
     */
    public void setDelayInSeconds(int delayInSeconds) {
        this.delayInSeconds = delayInSeconds;
    }

    /**
     * get a Assignment
     *
     * @return Assignment
     */
    public Assignment getAssignment() {
        return assignment;
    }

    /**
     * set a Assignment
     *
     * @param assignment
     */
    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    /**
     * get a hint Id
     *
     * @return long
     */
    public long getHintId() {
        return this.id;
    }

    /**
     * get name of a hint
     *
     * @return string
     */
    public String getName() {
        return this.name;
    }

    /**
     * set name of a hint
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get description of a hint
     *
     * @return String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * set description of a hint
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
