/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Request;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class ChangePasswordRequestMessage extends BaseMessage {
    
    public static final String MessageType = MessageTypes.ChangePasswordRequestMessage.toString();
    
    private Long userId;
    private String oldPassword;
    private String newPassword;
    
    public ChangePasswordRequestMessage(){}
    
    public ChangePasswordRequestMessage(Long userId, String oldPassword, String newPassword) {
        this.userId = userId;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
    
    public static ChangePasswordRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonUserId = (Long) obj.get("UserId");
        String jsonOldPassword = obj.get("OldPassword").toString();
        String jsonNewPassword = obj.get("NewPassword").toString();
        return new ChangePasswordRequestMessage(jsonUserId, jsonOldPassword, jsonNewPassword);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.MessageType);
        obj.put("UserId", this.userId);
        obj.put("OldPassword", this.oldPassword);
        obj.put("NewPassword", this.newPassword);
        return obj.toJSONString();
    }

    /**
     * @return the newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * @param newPassword the newPassword to set
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * @return the oldPassword
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * @param oldPassword the oldPassword to set
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
}
