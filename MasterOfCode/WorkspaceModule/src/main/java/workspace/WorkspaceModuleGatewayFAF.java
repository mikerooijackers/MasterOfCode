/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workspace;

import mocjms.messages.reply.CreateWorkspaceReply;
import mocjms.messages.request.CreateWorkspaceRequest;
import mocjms.messaging.AsynchronousReplierFAF;
import mocjms.messaging.requestreply.IRequestListener;
import mocjms.messaging.requestreply.IRequestReplySerializer;

/**
 *
 * @author Gebruiker
 */
public abstract class WorkspaceModuleGatewayFAF extends AsynchronousReplierFAF<CreateWorkspaceRequest,CreateWorkspaceReply> {

    public WorkspaceModuleGatewayFAF(String requestReceiverQueue, String replySenderQueue, IRequestReplySerializer<CreateWorkspaceRequest, CreateWorkspaceReply> serializer) throws Exception {
        super(requestReceiverQueue, replySenderQueue, serializer);
        
        IRequestListener<CreateWorkspaceRequest> requestListener = new IRequestListener<CreateWorkspaceRequest>() {

            @Override
            public void receivedRequest(CreateWorkspaceRequest request) {
                    onRequestReceived(request);
                }
            };
        this.setRequestListener(requestListener);
    }
    
    @Override
    public boolean sendReply(CreateWorkspaceReply reply) {
        return super.sendReply(reply);
    }
    
    abstract void onRequestReceived(CreateWorkspaceRequest request);
}
