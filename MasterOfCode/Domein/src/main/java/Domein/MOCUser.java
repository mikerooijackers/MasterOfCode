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
public class MOCUser implements Serializable {

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

    /**
     * get team
     * @return
     */
    public Team getTeam() {
        return team;
    }

    /**
     * set team
     * @param team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * get full name
     * @return
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * set full name
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * get mocuser id
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * set mocuser id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get password
     * @return
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * set password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get email
     * @return
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * set email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get name
     * @return
     */
    public String getName() {
        return this.fullName;
    }

    /**
     * set name
     * @param name
     */
    public void setName(String name) {
        this.fullName = name;
    }

    /**
     * get pprivilege
     * @return
     */
    public Role getPrivilege() {
        return this.privilege;
    }

    /**
     * set privilege
     * @param privilege
     */
    public void setPrivilege(Role privilege) {
        this.privilege = privilege;
    }

    /**
     * get activationCode
     * @return
     */
    public String getActivationCode() {
        return activationCode;
    }

    /**
     * set activationCode
     * @param activationCode
     */
    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

}
