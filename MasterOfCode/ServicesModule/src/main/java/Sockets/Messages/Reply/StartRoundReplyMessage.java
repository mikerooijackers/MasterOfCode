/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Reply;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class StartRoundReplyMessage extends BaseMessage {
    
    /**
     *
     */
    public static final String messageType = MessageTypes.StartRoundReplyMessage.toString();
    
    private String assignCreatorName;
    private String assignCreatorCompany;
    private String assignCreatorWeb;
    
    private String assignName;
    private String assignDescriptionCompetitors;
    private String assignDescriptionSpectators;
    
    /**
     * Constructor
     */
    public StartRoundReplyMessage(){}
    
    /**
     * Constructor
     * @param assignCreatorName
     * @param assignCreatorCompany
     * @param assignCreatorWeb
     * @param assignName
     * @param assignDescriptionCompetitors
     * @param assignDescriptionSpectators
     */
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
    
    /**
     *
     * @param s
     * @return
     */
    public static StartRoundReplyMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        String jsonAssignCreatorName = obj.get("AssignCreatorName").toString();
        String jsonAssignCreatorCompany = obj.get("AssignCreatorCompany").toString();
        String jsonAssignCreatorWeb = obj.get("AssignCreatorWeb").toString();
        String jsonAssignName = obj.get("AssignName").toString();
        String jsonAssignDescriptionCompetitors = obj.get("AssignDescriptionCompetitors").toString();
        String jsonAssignDescriptionSpectators = obj.get("AssignDescriptionSpectators").toString();
        
        return new StartRoundReplyMessage(jsonAssignCreatorName, jsonAssignCreatorCompany, jsonAssignCreatorWeb, jsonAssignName, jsonAssignDescriptionCompetitors, jsonAssignDescriptionSpectators);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("AssignCreatorName", this.assignCreatorName);
        obj.put("AssignCreatorCompany", this.assignCreatorCompany);
        obj.put("AssignCreatorWeb", this.assignCreatorWeb);
        obj.put("AssignName", this.assignName);
        obj.put("AssignDescriptionCompetitors", this.assignDescriptionCompetitors);
        obj.put("AssignDescriptionSpectators", this.assignDescriptionSpectators);
        return obj.toString();
    }
}
