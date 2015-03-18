package Domein;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hint {

	/**
	 * numeber of a hint
	 */
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
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
        
        private Assignment assignment;

    public Hint() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDelayInSeconds() {
        return delayInSeconds;
    }

    public void setDelayInSeconds(int delayInSeconds) {
        this.delayInSeconds = delayInSeconds;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

	public int getHintId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}