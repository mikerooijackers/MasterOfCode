/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package workspace;

import mocjms.messages.reply.CreateWorkspaceReply;
import mocjms.messages.request.CreateWorkspaceRequest;
import mocjms.messaging.requestreply.AsynchronousReplier;
import mocjms.messaging.requestreply.IRequestListener;
import mocjms.messaging.requestreply.IRequestReplySerializer;

/**
 *
 * @author Gebruiker
 */
public abstract class WorkspaceModuleGateway extends AsynchronousReplier<CreateWorkspaceRequest, CreateWorkspaceReply> {
    //private MessagingGateway gtw;
    //private BankSerializer ser;
    //private AsynchronousReplier<BankQuoteRequest,BankQuoteReply> replier;
    //private IRequestListener<BankQuoteRequest> requestListener;

    public WorkspaceModuleGateway(String requestReceiverQueue, IRequestReplySerializer serializer) throws Exception {
        super(requestReceiverQueue, serializer);
        IRequestListener<CreateWorkspaceRequest> requestListener = new IRequestListener<CreateWorkspaceRequest>() {

            @Override
            public void receivedRequest(CreateWorkspaceRequest request) {
                    onCreateWorkspaceRequest(request);
                }
            };
        this.setRequestListener(requestListener);
    }
    
    abstract void onCreateWorkspaceRequest(CreateWorkspaceRequest r);
}
