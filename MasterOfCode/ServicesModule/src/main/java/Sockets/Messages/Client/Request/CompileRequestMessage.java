/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Request;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import Sockets.Messages.Client.Reply.CompileReplyMessage;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class CompileRequestMessage extends BaseMessage {

    /**
     *
     */
    public static final String messageType = MessageTypes.CompileRequestMessage.toString();

    private Long teamId;

    /**
     * Constructor
     */
    public CompileRequestMessage() {
    }

    /**
     * Constructor
     *
     * @param teamId
     */
    public CompileRequestMessage(Long teamId) {
        this.teamId = teamId;
    }

    /**
     * @return the teamId
     */
    public Long getTeamId() {
        return teamId;
    }

    /**
     * @param teamId the teamId to set
     */
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    /**
     *
     * @param s
     * @return
     */
    public static CompileRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonTeamId = (Long) obj.get("TeamId");
        return new CompileRequestMessage(jsonTeamId);
    }

    @Override
    public void doAction(CommunicationBean communicationBean) {
        CompileReplyMessage mess = new CompileReplyMessage("[INFO] Scanning for projects...\n"
                + "[INFO]\n"
                + "[INFO] ------------------------------------------------------------------------\n"
                + "[INFO] Building Kwetter GWT 1.0-SNAPSHOT\n"
                + "[INFO] ------------------------------------------------------------------------\n"
                + "[INFO]\n"
                + "[INFO] --- gwt-maven-plugin:2.6.1:i18n (default) @ Kwetter-GWT-JEE7 ---\n"
                + "[INFO]\n"
                + "[INFO] --- gwt-maven-plugin:2.6.1:generateAsync (default) @ Kwetter-GWT-JEE7 ---\n"
                + "[INFO]\n"
                + "[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ Kwetter-GW\n"
                + "[INFO] Using 'UTF-8' encoding to copy filtered resources.\n"
                + "[INFO] Copying 4 resources\n"
                + "[INFO]\n"
                + "[INFO] --- maven-compiler-plugin:2.3.2:compile (default-compile) @ Kwetter-GWT-J\n"
                + "[INFO] Compiling 1 source file to C:\\Users\\JordiK\\Documents\\School\\JEA6\\GWT-JEE7\n"
                + "[INFO]\n"
                + "[INFO] --- maven-war-plugin:2.1.1:exploded (default) @ Kwetter-GWT-JEE7 ---\n"
                + "[INFO] Exploding webapp\n"
                + "[INFO] Assembling webapp [Kwetter-GWT-JEE7] in [C:\\Users\\JordiK\\Documents\\School\n"
                + "[INFO] Processing war project\n"
                + "[INFO] Copying webapp resources [C:\\Users\\JordiK\\Documents\\School\\JEA6\\GWT-JEE7\\\n"
                + "[INFO] Webapp assembled in [525 msecs]\n"
                + "[INFO] ------------------------------------------------------------------------\n"
                + "[INFO] BUILD SUCCESS\n"
                + "[INFO] ------------------------------------------------------------------------\n"
                + "[INFO] Total time: 14.849 s\n"
                + "[INFO] Finished at: 2015-06-03T13:00:18+02:00\n"
                + "[INFO] Final Memory: 18M/50M\n"
                + "[INFO] ------------------------------------------------------------------------", 0L);
        communicationBean.sendMessageToCompetitor("Noor", mess);
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("TeamId", this.teamId);
        return obj.toString();
    }
}
