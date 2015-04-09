/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import Domein.Team;
import mocjms.messages.reply.CreateWorkspaceReply;
import mocjms.messages.request.CreateWorkspaceRequest;
import mocjms.serializers.CreateWorkspaceSerializer;

/**
 *
 * @author Gebruiker
 */
public class Client {

    private ClientGateway clientGateway;
    
    private ClientGatewayFAF clientGatewayFAF;
    
    public Client(String createWorkspaceRequestQueue, String createWorkspaceReplyQueue) throws Exception {
//        clientGateway = new ClientGateway(createWorkspaceRequestQueue, createWorkspaceReplyQueue, new CreateWorkspaceSerializer()) {
//            
//            @Override
//            void onReplyReceived(CreateWorkspaceRequest request, CreateWorkspaceReply reply) {
//                // TODO
//                System.out.println("REPLY RECEIVED");
//            }
//        };
        
        clientGatewayFAF = new ClientGatewayFAF(createWorkspaceRequestQueue, createWorkspaceReplyQueue, new CreateWorkspaceSerializer()) {
            
            @Override
            void onReplyReceived(CreateWorkspaceReply reply) {
                System.out.println("FAF REPLY RECEIVED");
            }
        };
    }
    
    public void start() {
//        clientGateway.start();
//        
//        Team team = new Team();
//        team.setId(1L);
//        System.out.println("SENDING REQUEST");
//        clientGateway.sendRequest(new CreateWorkspaceRequest(team, "something"));
        
        clientGatewayFAF.start();
        Team team = new Team();
        team.setId(1L);
        System.out.println("SENDING REQUEST");
        clientGatewayFAF.sendRequest(new CreateWorkspaceRequest(team, "something"));
    }
}
