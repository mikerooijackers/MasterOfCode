/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import java.util.List;
import java.util.Map;
import javax.websocket.Session;

/**
 *
 * @author mikerooijackers
 */
public class WebSocket {
    private List<Session> spectatorPeers;
    private Map<Long, Session> userPeers;
    private Map<Long, Session> participantTeam;
    
    public void onMessage(Long userID, Long teamID, Session client, String message) {
        
    }
    
    public void onClose(Long userID, Long teamID, Session client) {
        
    }
    
    public void onOpen(Long userID, Long teamID, Session client) {
        
    }
    
    public void onError(Throwable t) {
        
    }
    
    public void sendMessageToUser(long UserID, Object message) {
        
    }
    
    public void sendMessageToTeam(long TeamID, Object message) {
        
    }
    
    public void sendMessageToSpectator(Object message) {
        
    }
    
    public void sendMessageToParticipant(Object message) {
        
    }
}
