/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Reply;

import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class StartRoundReplyMessage extends BaseMessage {
    
    public static final String MessageType = "startRoundMessage";
    
    private String assignCreatorName;
    private String assignCreatorCompany;
    private String assignCreatorWeb;
    
    private String assignName;
    private String assignDescriptionCompetitors;
    private String assignDescriptionSpectators;
    
    public StartRoundReplyMessage(){}
    
    public StartRoundReplyMessage(String assignCreatorName, String assignCreatorCompany, String assignCreatorWeb, String assignName, String assignDescriptionCompetitors, String assignDescriptionSpectators) {
        this.assignCreatorName = assignCreatorName;
        this.assignCreatorCompany = assignCreatorCompany;
        this.assignCreatorWeb = assignCreatorWeb;
        this.assignName = assignName;
        this.assignDescriptionCompetitors = assignDescriptionCompetitors;
        this.assignDescriptionSpectators = assignDescriptionSpectators;
    }

    /**
     * @return the assignCreatorName
     */
    public String getAssignCreatorName() {
        return assignCreatorName;
    }

    /**
     * @param assignCreatorName the assignCreatorName to set
     */
    public void setAssignCreatorName(String assignCreatorName) {
        this.assignCreatorName = assignCreatorName;
    }

    /**
     * @return the assignCreatorCompany
     */
    public String getAssignCreatorCompany() {
        return assignCreatorCompany;
    }

    /**
     * @param assignCreatorCompany the assignCreatorCompany to set
     */
    public void setAssignCreatorCompany(String assignCreatorCompany) {
        this.assignCreatorCompany = assignCreatorCompany;
    }

    /**
     * @return the assignCreatorWeb
     */
    public String getAssignCreatorWeb() {
        return assignCreatorWeb;
    }

    /**
     * @param assignCreatorWeb the assignCreatorWeb to set
     */
    public void setAssignCreatorWeb(String assignCreatorWeb) {
        this.assignCreatorWeb = assignCreatorWeb;
    }

    /**
     * @return the assignName
     */
    public String getAssignName() {
        return assignName;
    }

    /**
     * @param assignName the assignName to set
     */
    public void setAssignName(String assignName) {
        this.assignName = assignName;
    }

    /**
     * @return the assignDescriptionCompetitors
     */
    public String getAssignDescriptionCompetitors() {
        return assignDescriptionCompetitors;
    }

    /**
     * @param assignDescriptionCompetitors the assignDescriptionCompetitors to set
     */
    public void setAssignDescriptionCompetitors(String assignDescriptionCompetitors) {
        this.assignDescriptionCompetitors = assignDescriptionCompetitors;
    }

    /**
     * @return the assignDescriptionSpectators
     */
    public String getAssignDescriptionSpectators() {
        return assignDescriptionSpectators;
    }

    /**
     * @param assignDescriptionSpectators the assignDescriptionSpectators to set
     */
    public void setAssignDescriptionSpectators(String assignDescriptionSpectators) {
        this.assignDescriptionSpectators = assignDescriptionSpectators;
    }
    
    public static StartRoundReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        String jsonAssignCreatorName = obj.get("assignCreatorName").toString();
        String jsonAssignCreatorCompany = obj.get("assignCreatorCompany").toString();
        String jsonAssignCreatorWeb = obj.get("assignCreatorWeb").toString();
        String jsonAssignName = obj.get("assignName").toString();
        String jsonAssignDescriptionCompetitors = obj.get("assignDescriptionCompetitors").toString();
        String jsonAssignDescriptionSpectators = obj.get("assignDescriptionSpectators").toString();
        
        return new StartRoundReplyMessage(jsonAssignCreatorName, jsonAssignCreatorCompany, jsonAssignCreatorWeb, jsonAssignName, jsonAssignDescriptionCompetitors, jsonAssignDescriptionSpectators);
    }
}
