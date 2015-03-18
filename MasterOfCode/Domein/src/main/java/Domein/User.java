package Domein;

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
	private String name;
	/**
	 * privileges of a user
	 */
	private Privilege privileges;

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
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Privilege getPrivileges() {
		return this.privileges;
	}

	public void setPrivileges(Privilege privileges) {
		this.privileges = privileges;
	}

}