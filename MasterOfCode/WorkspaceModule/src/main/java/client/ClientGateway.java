/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import mocjms.messages.reply.CreateWorkspaceReply;
import mocjms.messages.request.CreateWorkspaceRequest;
import mocjms.messaging.requestreply.AsynchronousRequestor;
import mocjms.messaging.requestreply.IReplyListener;
import mocjms.messaging.requestreply.IRequestReplySerializer;

/**
 *
 * @author Gebruiker
 */
public abstract class ClientGateway extends AsynchronousRequestor<CreateWorkspaceRequest, CreateWorkspaceReply> {
    
    private IReplyListener<CreateWorkspaceRequest,CreateWorkspaceReply> replyListener;

    public ClientGateway(String requestSenderQueue, String replyReceiverQueue, IRequestReplySerializer serializer) throws Exception {
        super(requestSenderQueue, replyReceiverQueue, serializer);
        
        replyListener = new IReplyListener<CreateWorkspaceRequest,CreateWorkspaceReply>() {

            @Override
            public void onReply(CreateWorkspaceRequest request, CreateWorkspaceReply reply) {
                onReplyReceived(request, reply);
            }
        };
    }
    
    public void sendRequest(CreateWorkspaceRequest request) {
        super.sendRequest(request, replyListener);
    }
    
    abstract void onReplyReceived(CreateWorkspaceRequest request, CreateWorkspaceReply reply);
}
