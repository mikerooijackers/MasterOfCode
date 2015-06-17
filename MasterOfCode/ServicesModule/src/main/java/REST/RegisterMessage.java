/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import domein.Role;
import java.util.UUID;

/**
 *
 * @author mikerooijackers
 */

class RegisterMessage {
    private String email;
    private String fullname;
    private String password;
    private String company;
    private String telephone;
    private Role privilege;
    private String activationCode;
    
    public RegisterMessage(){}
    
    public RegisterMessage(String email, String fullname, String password, Role privilege, String company, String telephone) {
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.privilege = privilege;
        this.company = company;
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword() {
        return password;
    }

    public Role getPrivilege() {
        return privilege;
    }

    public String getActivationCode() {
        activationCode = UUID.randomUUID().toString();
        return activationCode;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param privilege the privilege to set
     */
    public void setPrivilege(Role privilege) {
        this.privilege = privilege;
    }

    /**
     * @param activationCode the activationCode to set
     */
    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
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
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    
}
