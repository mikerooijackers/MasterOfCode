/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workspace;

import mocjms.messages.reply.CreateWorkspaceReply;
import mocjms.messages.request.CreateWorkspaceRequest;
import mocjms.messaging.requestreply.IRequestReplySerializer;
import mocjms.serializers.CreateWorkspaceSerializer;

/**
 *
 * @author Gebruiker
 */
public class WorkspaceModule {
    
    private WorkspaceModuleGateway workspaceModuleGateway;
    
    private WorkspaceModuleGatewayFAF workspaceModuleGatewayFAF;

    public WorkspaceModule(String createWorkspaceRequestQueue, String createWorkspaceReplyQueue) throws Exception {
        //final CreateWorkspaceSerializer createWorkspaceSerlializer = new CreateWorkspaceSerializer();
//        workspaceModuleGateway = new WorkspaceModuleGateway(createWorkspaceRequestQueue, new CreateWorkspaceSerializer()) {
//
//            @Override
//            void onCreateWorkspaceRequest(CreateWorkspaceRequest r) {
//                System.out.println("RECEIVED REQUEST");
//                WorkspaceModule.this.onCreateWorkspaceRequest(r);
//            }
//        };
        
        workspaceModuleGatewayFAF = new WorkspaceModuleGatewayFAF(createWorkspaceRequestQueue, createWorkspaceReplyQueue, new CreateWorkspaceSerializer()) {
            
            @Override
            void onRequestReceived(CreateWorkspaceRequest request) {
                System.out.println("RECEIVED REQUEST FAF");
                WorkspaceModule.this.onCreateWorkspaceRequest(request);
            }
        };
    }
    
    private void onCreateWorkspaceRequest(CreateWorkspaceRequest r) {
        System.out.println("SENDING REPLY");
        //this.workspaceModuleGateway.sendReply(r, new CreateWorkspaceReply("blabla"));
        
        this.workspaceModuleGatewayFAF.sendReply(new CreateWorkspaceReply("blabla"));
    }
    
    public void start() {
        //workspaceModuleGateway.start();
        workspaceModuleGatewayFAF.start();
    }
}
