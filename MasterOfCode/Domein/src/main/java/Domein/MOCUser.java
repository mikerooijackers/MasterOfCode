package Domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MOCUser {
    
    private String activationCode;

	/**
	 * password of a user
	 */
	private String password;
	/**
	 * email of a user
	 */
	private String email;
	/**
	 * name of a user
	 */
	private String fullName;
	/**
	 * privileges of a user
	 */
	private Role privilege;
        
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        
        @ManyToOne
        private Team team;

    public MOCUser() {
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }    
        
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.fullName;
	}

	public void setName(String name) {
		this.fullName = name;
	}

	public Role getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(Role privilege) {
		this.privilege = privilege;
	}

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

}