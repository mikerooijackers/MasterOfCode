/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Admin.Request;

import Enumerations.MessageTypes;
import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mikerooijackers
 */
public class RegisterMemberRequestMessage extends BaseMessage {
    
    public static final String messageType = MessageTypes.RegisterMemberRequestMessage.toString();
    
    private String username;
    private String name;
    private String password;
    private String phone;
    private String organization;
    
    public RegisterMemberRequestMessage(){}
    
    public RegisterMemberRequestMessage(String username, String name, String password, String phone, String organization){
        this.username = username;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.organization = organization;
    }
    
    public static RegisterMemberRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        String jsonUsername = obj.get("Username").toString();
        String jsonName = obj.get("Name").toString();
        String jsonPassword = obj.get("Password").toString();
        String jsonPhone = obj.get("Phone").toString();
        String jsonOrganization = obj.get("Organization").toString();
        return new RegisterMemberRequestMessage(jsonUsername, jsonName, jsonPassword, jsonPhone, jsonOrganization);
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("Username", this.username);
        obj.put("Name", this.name);
        obj.put("Password", this.password);
        obj.put("Phone", this.phone);
        obj.put("Organization", this.organization);
        return obj.toJSONString();
    }
    
}
