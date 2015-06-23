/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Admin.Request;

import Domein.MOCUser;
import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mikerooijackers
 */
public class RegisterMemberRequestMessage extends BaseMessage {
    
    /**
     *
     */
    public static final String messageType = MessageTypes.RegisterMemberRequestMessage.toString();
    
    private String username;
    private String name;
    private String password;
    private String phone;
    private String organization;
    
    /**
     *
     */
    public RegisterMemberRequestMessage(){
    }
    
    /**
     *
     * @param username
     * @param name
     * @param phone
     * @param organization
     */
    public RegisterMemberRequestMessage(String username, String name, String phone, String organization){
        this.username = username;
        this.name = name;
        this.password = "password";
        this.phone = phone;
        this.organization = organization;
    }
    
    /**
     *
     * @param username
     * @param name
     * @param password
     * @param phone
     * @param organization
     */
    public RegisterMemberRequestMessage(String username, String name, String password, String phone, String organization){
        this.username = username;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.organization = organization;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static RegisterMemberRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        String jsonUsername = obj.get("Username").toString();
        String jsonName = obj.get("Name").toString();
        String jsonPhone = obj.get("Phone").toString();
        String jsonOrganization = obj.get("Organization").toString();
        return new RegisterMemberRequestMessage(jsonUsername, jsonName, jsonPhone, jsonOrganization);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        MOCUser user = new MOCUser();
        System.out.println("In the do action of RegisterMemberRequestMessage");
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
