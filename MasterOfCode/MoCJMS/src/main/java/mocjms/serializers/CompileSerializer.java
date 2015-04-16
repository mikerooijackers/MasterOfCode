/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.serializers;

import com.thoughtworks.xstream.XStream;
import mocjms.messages.reply.CompileReply;
import mocjms.messages.request.CompileRequest;
import mocjms.messaging.requestreply.IRequestReplySerializer;

/**
 *
 * @author May
 */
public class CompileSerializer  implements IRequestReplySerializer<CompileRequest, CompileReply> {

    private static final String ALIAS_REQUEST = "CompileRequest"; // tag name for request
    private static final String ALIAS_REPLY = "CompileReply"; // tag name for reply
    private XStream xstream; // class for serialization

    public CompileSerializer() {
        super();
        xstream = new XStream();
         // register aliases (i.e., tag names)
        xstream.alias(ALIAS_REQUEST, CompileRequest.class);
        xstream.alias(ALIAS_REPLY, CompileReply.class);
    }
    
    @Override
    public CompileRequest requestFromString(String str) {
        return (CompileRequest) xstream.fromXML(str);
    }

    @Override
    public CompileReply replyFromString(String str) {
        return (CompileReply) xstream.fromXML(str);
    }

    @Override
    public String requestToString(CompileRequest request) {
        return xstream.toXML(request);
    }

    @Override
    public String replyToString(CompileReply reply) {
        return xstream.toXML(reply);
    }  
}
