/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import Domein.Role;
import java.util.UUID;

/**
 *
 * @author mikerooijackers
 */

class RegisterMessage {
    private String email;
    private String fullname;
    private String password;
    private Role privilege;
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

    public Role getPrivilege() {
        return privilege;
    }

    public String getActivationCode() {
        activationCode = UUID.randomUUID().toString();
        return activationCode;
    }
    
    
}
