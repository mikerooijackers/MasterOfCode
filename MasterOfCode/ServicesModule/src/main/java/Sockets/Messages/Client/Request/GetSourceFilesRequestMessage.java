/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages.Client.Request;

import Enumerations.MessageTypes;
import Service.CommunicationBean;
import Sockets.Messages.BaseMessage;
import Sockets.Messages.Client.Reply.GetSourceFilesReplyMessage;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author mikerooijackers
 */
public class GetSourceFilesRequestMessage extends BaseMessage {

    /**
     *
     */
    public static final String messageType = MessageTypes.GetSourceFilesRequestMessage.toString();
    
    private Long teamId;
    
    /**
     * Constructor
     */
    public GetSourceFilesRequestMessage() {}
    
    public GetSourceFilesRequestMessage(Long teamId) {
        this.teamId = teamId;
    }
    
    public static GetSourceFilesRequestMessage decodeJSON(String s) {
        JSONObject obj = (JSONObject) JSONValue.parse(s);
        Long jsonTeamId = (Long) obj.get("TeamId");
        return new GetSourceFilesRequestMessage(jsonTeamId);
    }
    
    @Override
    public void doAction(CommunicationBean communicationBean) {
        HashMap<String, String> map = new HashMap<>();
        map.put("C:\\Users\\JordiK\\Documents\\School\\PTS6\\MasterOfCode\\SourceFile1", "package REST;\n"
                + "\n"
                + "import javax.ws.rs.core.*;\n"
                + "import javax.ws.rs.*;\n"
                + "import Domein.*;\n"
                + "\n"
                + "/**\n"
                + " * REST Web Service\n"
                + " *\n"
                + " * @author mikerooijackers\n"
                + " */\n"
                + "@Path(\"\")\n"
                + "public class RestResource {\n"
                + "\n"
                + "    /**\n"
                + "     * Creates a new instance of RestResource\n"
                + "     */\n"
                + "    public RestResource() {\n"
                + "    }\n"
                + "    \n"
                + "    @POST\n"
                + "    @Path(\"startcompetition\")\n"
                + "    public String startCompetition () {\n"
                + "        \n"
                + "        return \"\";\n"
                + "    }\n"
                + "    \n"
                + "    @POST\n"
                + "    @Path(\"pausecompetition\")\n"
                + "    public String pauseCompetition () {\n"
                + "        \n"
                + "        return \"\";\n"
                + "    }\n"
                + "    \n"
                + "    @POST\n"
                + "    @Path(\"freezecompetition\")\n"
                + "    public String freezeCompetition () {\n"
                + "        \n"
                + "        return \"\";\n"
                + "    }\n"
                + "    \n"
                + "    @POST\n"
                + "    @Path(\"stopcompetition\")\n"
                + "    public String stopCompetition () {\n"
                + "        \n"
                + "        return \"\";\n"
                + "    }\n"
                + "    \n"
                + "    @POST\n"
                + "    @Path(\"startround\")\n"
                + "    public String startRound () {\n"
                + "        \n"
                + "        return \"\";\n"
                + "    }\n"
                + "    \n"
                + "    @POST\n"
                + "    @Path(\"pauseround\")\n"
                + "    public String pauseRound () {\n"
                + "        \n"
                + "        return \"\";\n"
                + "    }\n"
                + "    \n"
                + "    @POST\n"
                + "    @Path(\"freezeround\")\n"
                + "    public String freezeRound () {\n"
                + "        \n"
                + "        return \"\";\n"
                + "    }\n"
                + "    \n"
                + "    @POST\n"
                + "    @Path(\"stopround\")\n"
                + "    public String stopRound () {\n"
                + "        \n"
                + "        return \"\";\n"
                + "    }\n"
                + "}");
        map.put("SourceFile2", "package Sockets.Messages.Client.Reply;\n"
                + "\n"
                + "import Enumerations.MessageTypes;\n"
                + "import Service.CommunicationBean;\n"
                + "import Sockets.Messages.BaseMessage;\n"
                + "import java.util.Map;\n"
                + "import org.json.simple.JSONObject;\n"
                + "import org.json.simple.JSONValue;\n"
                + "\n"
                + "/**\n"
                + " *\n"
                + " * @author mikerooijackers\n"
                + " */\n"
                + "public class GetSourceFilesReplyMessage extends BaseMessage {\n"
                + "    \n"
                + "    public static final String messageType = MessageTypes.GetSourceFilesReplyMessage.toString();\n"
                + "    \n"
                + "    private Map<String, String> sourceFiles;\n"
                + "    \n"
                + "    public GetSourceFilesReplyMessage(){}\n"
                + "    \n"
                + "    public GetSourceFilesReplyMessage(Map<String, String> sourceFiles) {\n"
                + "        this.sourceFiles = sourceFiles;\n"
                + "    }\n"
                + "    \n"
                + "    public static GetSourceFilesReplyMessage decodeJSON(String s) {\n"
                + "        JSONObject obj = (JSONObject) JSONValue.parse(s);\n"
                + "        Map<String, String> jsonSourceFiles = (Map<String, String>) obj.get(\"SourceFiles\");\n"
                + "        return new GetSourceFilesReplyMessage(jsonSourceFiles);\n"
                + "    } \n"
                + "\n"
                + "    @Override\n"
                + "    public void doAction(CommunicationBean communicationBean) {\n"
                + "        throw new UnsupportedOperationException(\"Not supported yet.\"); //To change body of generated methods, choose Tools | Templates.\n"
                + "    }\n"
                + "\n"
                + "    @Override\n"
                + "    public String toJSONString() {\n"
                + "        JSONObject obj = new JSONObject();\n"
                + "        obj.put(\"MessageType\", this.messageType);\n"
                + "        obj.put(\"SourceFiles\", this.sourceFiles);\n"
                + "        return obj.toJSONString();\n"
                + "    }\n"
                + "    \n"
                + "}");
        GetSourceFilesReplyMessage mess = new GetSourceFilesReplyMessage(map);
        communicationBean.sendMessageToCompetitor(this.teamId, mess);
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("MessageType", this.messageType);
        obj.put("TeamId", this.teamId);
        return obj.toString();
    }
    
}
