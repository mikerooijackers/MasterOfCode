/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import mocjms.messages.reply.CreateWorkspaceReply;
import mocjms.messages.request.CreateWorkspaceRequest;
import mocjms.messaging.AsynchronousRequestorFAF;
import mocjms.messaging.IReplyListenerFAF;
import mocjms.messaging.requestreply.IRequestReplySerializer;

/**
 *
 * @author Gebruiker
 */
public abstract class ClientGatewayFAF extends AsynchronousRequestorFAF<CreateWorkspaceRequest, CreateWorkspaceReply> {

    private IReplyListenerFAF<CreateWorkspaceReply> replyListener;
    
    public ClientGatewayFAF(String requestSenderQueue, String replyReceiverQueue, IRequestReplySerializer<CreateWorkspaceRequest, CreateWorkspaceReply> serializer) throws Exception {
        super(requestSenderQueue, replyReceiverQueue, serializer);
        
        replyListener = new IReplyListenerFAF<CreateWorkspaceReply>() {

            @Override
            public void receivedReply(CreateWorkspaceReply reply) {
                onReplyReceived(reply);
            }
        };
        
        this.setReplyListener(replyListener);
    }
    
    @Override
    public void sendRequest(CreateWorkspaceRequest request) {
        super.sendRequest(request);
    }
    
    abstract void onReplyReceived(CreateWorkspaceReply reply);
}
