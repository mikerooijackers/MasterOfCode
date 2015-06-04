/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

/**
 *
 * @author mikerooijackers
 */

class RegisterMessage {
    private String email;
    private String fullname;
    private String password;
    private int privilege;
    private int teamID;
    private String activationCode;

    public String getEmail() {
        return email;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword() {
        return password;
    }

    public int getPrivilege() {
        return privilege;
    }

    public int getTeamID() {
        return teamID;
    }

    public String getActivationCode() {
        return activationCode;
    }
    
    
}
