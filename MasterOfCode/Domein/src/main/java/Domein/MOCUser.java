package Domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

@Entity
public class MOCUser implements JSONAware{

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
    private Role privilege;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Team team;

    public MOCUser() {
    }

    public MOCUser(String username, String password, String email, String fullName, Role privilege, Team team) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.privilege = privilege;
        this.team = team;
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

    public Role getPrivilege() {
        return this.privilege;
    }

    public void setPrivilege(Role privilege) {
        this.privilege = privilege;
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("Username", this.username);
        obj.put("Fullname", this.fullName);
//        obj.put("Id", this.id);
        obj.put("Email", this.email);
        obj.put("Password", this.password);
        return obj.toJSONString();
    }
    
    @Override
    public String toString() {
        JSONObject obj = new JSONObject();
        obj.put("Username", this.username);
        obj.put("Fullname", this.fullName);
//        obj.put("Id", this.id);
        obj.put("Email", this.email);
        obj.put("Password", this.password);
        return obj.toJSONString();
    }
}
