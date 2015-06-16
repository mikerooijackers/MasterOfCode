package Domein;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

/**
 *
 * @author mikerooijackers
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "AllUsers", query = "SELECT m FROM MOCUser m"),
    @NamedQuery(name = "LoginUser", query = "SELECT m FROM MOCUser m WHERE m.email LIKE :email AND m.password LIKE :password")
})
public class MOCUser implements Serializable, JSONAware {

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

    private String activationCode;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Team team;

    /**
     * constructor
     */
    public MOCUser() {
    }

    public MOCUser(String username, String password, String email, String fullName, Role privilege, Team team, String company, String telephoneNumber) {
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.privilege = privilege;
        this.team = team;
        this.company = company;
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("Fullname", this.fullName);
//        obj.put("Id", this.id);
        obj.put("Email", this.email);
        obj.put("Password", this.password);
        obj.put("Company", this.company);
        obj.put("TelephoneNumber", this.telephoneNumber);
        return obj.toJSONString();
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the privilege
     */
    public Role getPrivilege() {
        return privilege;
    }

    /**
     * @param privilege the privilege to set
     */
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

    /**
     * @return the activationCode
     */
    public String getActivationCode() {
        return activationCode;
    }

    /**
     * @param activationCode the activationCode to set
     */
    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(Team team) {
        this.team = team;
    }
}
