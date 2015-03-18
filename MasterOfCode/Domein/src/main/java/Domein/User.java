package Domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	/**
	 * username of a user
	 */
	private String username;
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
	private Privilege privileges;
        
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

    public User() {
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Privilege getPrivileges() {
		return this.privileges;
	}

	public void setPrivileges(Privilege privileges) {
		this.privileges = privileges;
	}

}