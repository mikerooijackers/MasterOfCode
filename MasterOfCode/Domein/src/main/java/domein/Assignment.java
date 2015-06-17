package domein;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mikerooijackers
 */
@Entity
public class Assignment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String path;

    /**
     * Constructor Assignment
     */
    public Assignment() {
    }

    /**
     * get ID of a Assignment
     *
     * @return long
     */
    public long getId() {
        return id;
    }

    /**
     * set ID of a Assignment
     *
     * @param id
     */
    public void setId(long id) {
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
}
