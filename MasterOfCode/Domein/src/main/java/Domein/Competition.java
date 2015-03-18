package Domein;

import java.util.Calendar;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Competition {

	/**
	 * id of a competition
	 */
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/**
	 * name of a competition
	 */
	private String name;

	/**
	 * start time of a competition
	 */
	private Calendar startTime;
	private Status status;
        
        @ManyToMany(cascade=CascadeType.ALL, mappedBy="competition")
        private Collection<Assignment> assignments;

	public int getCompetitionId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

	public Calendar getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

}