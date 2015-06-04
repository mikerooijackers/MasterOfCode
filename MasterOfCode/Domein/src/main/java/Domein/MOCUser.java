package Domein;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

@Entity
public class MOCUser implements JSONAware, Serializable{

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
    
    private String company;
    
    private String telephoneNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Team team;

    public MOCUser() {
    }

    public MOCUser(String username, String password, String email, String fullName, Role privilege, Team team, String company, String telephoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.privilege = privilege;
        this.team = team;
        this.company = company;
        this.telephoneNumber = telephoneNumber;
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
    
        /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the telephoneNumber
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    
    /**
     * @param telephoneNumber the telephoneNumber to set
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("Username", this.username);
        obj.put("Fullname", this.fullName);
//        obj.put("Id", this.id);
        obj.put("Email", this.email);
        obj.put("Password", this.password);
        obj.put("Company", this.company);
        obj.put("TelephoneNumber", this.telephoneNumber);
        return obj.toJSONString();
    }
}
