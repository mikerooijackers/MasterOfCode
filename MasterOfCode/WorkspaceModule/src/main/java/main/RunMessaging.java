/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import client.Client;
import java.util.logging.Level;
import java.util.logging.Logger;
import mocjms.main.JMSSettings;
import workspace.WorkspaceModule;

/**
 *
 * @author Gebruiker
 */
public class RunMessaging {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // read the queue names from file "MESSAGING.ini"
            JMSSettings.init("MESSAGING_CHANNELS.ini");
            JMSSettings.setRunMode(JMSSettings.RunMode.AUTOMATICALLY); // this means that the Bank will automatically generate an Interest rate and return it!
            
            final String createWorkspaceRequestQueue = JMSSettings.get(JMSSettings.CREATE_WORKSPACE_REQUEST);
            final String createWorkspaceReplyQueue = JMSSettings.get(JMSSettings.CREATE_WORKSPACE_REPLY);
            
            WorkspaceModule module = new WorkspaceModule(createWorkspaceRequestQueue, createWorkspaceReplyQueue);
            Client client = new Client(createWorkspaceRequestQueue, createWorkspaceReplyQueue);
            
            module.start();
            client.start();
            
        } catch (Exception ex) {
            Logger.getLogger(RunMessaging.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
