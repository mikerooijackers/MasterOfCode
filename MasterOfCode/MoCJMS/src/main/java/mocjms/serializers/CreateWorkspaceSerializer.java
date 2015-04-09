/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.serializers;

import com.thoughtworks.xstream.XStream;
import mocjms.messages.reply.CreateWorkspaceReply;
import mocjms.messages.request.CreateWorkspaceRequest;
import mocjms.messaging.requestreply.IRequestReplySerializer;

/**
 *
 * @author Gebruiker
 */
public class CreateWorkspaceSerializer implements IRequestReplySerializer<CreateWorkspaceRequest, CreateWorkspaceReply> {
    private static final String ALIAS_REQUEST = "CreateWorkspaceRequest"; // tag name for request
    private static final String ALIAS_REPLY = "CreateWorkspaceReply"; // tag name for reply
    private XStream xstream; // class for serialization

    public CreateWorkspaceSerializer() {
        super();
        xstream = new XStream();
         // register aliases (i.e., tag names)
        xstream.alias(ALIAS_REQUEST, CreateWorkspaceRequest.class);
        xstream.alias(ALIAS_REPLY, CreateWorkspaceReply.class);
    }

    /**
     * This method parses a request from an XML string.
     * @param str is the string containing the XML
     * @return the request containng the same information like the given XML (str)
     */
    @Override
    public CreateWorkspaceRequest requestFromString(String str) {
        return (CreateWorkspaceRequest) xstream.fromXML(str);
    }
    /**
     * This method parses a reply from an XML string.
     * @param str is the string containing the XML
     * @return the reply containng the same information like the given XML (str)
     */
    @Override
    public CreateWorkspaceReply replyFromString(String str) {
        return (CreateWorkspaceReply) xstream.fromXML(str);
    }
    
    /**
     * Serializes a request into an XML string.
     * @param request is the request to be serialized into XML
     * @return the string containing XML with information about the request
     */
    @Override
    public String requestToString(CreateWorkspaceRequest request) {
        return xstream.toXML(request);
    }
    /**
     * Serializes a reply into XML string.
     * @param reply is the reply to be serialized into XML
     * @return the string containing XML with information about the reply
     */
    @Override
    public String replyToString(CreateWorkspaceReply reply) {
        return xstream.toXML(reply);
    }
}
