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
    
    /**
     *
     */
    public static final String MessageType = MessageTypes.ChangePasswordRequestMessage.toString();
    
    private int userId;
    private String oldPassword;
    private String newPassword;
    
    /**
     *
     */
    public ChangePasswordRequestMessage(){
    }
    
    /**
     *
     * @param userId
     * @param oldPassword
     * @param newPassword
     */
    public ChangePasswordRequestMessage(int userId, String oldPassword, String newPassword) {
        this.userId = userId;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static ChangePasswordRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        long jsonUserIdLong = (Long) obj.get("UserId");
        int jsonUserId = (int) jsonUserIdLong;
        String jsonOldPassword = obj.get("OldPassword").toString();
        String jsonNewPassword = obj.get("NewPassword").toString();
        return new ChangePasswordRequestMessage(jsonUserId, jsonOldPassword, jsonNewPassword);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        String output = communicationBean.changePassword(userId, oldPassword, newPassword);
        System.out.println(output);
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
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}
