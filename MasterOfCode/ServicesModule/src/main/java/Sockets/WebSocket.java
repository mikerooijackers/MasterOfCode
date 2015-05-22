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
    
    /**
     *
     * @param userID
     * @param teamID
     * @param client
     * @param message
     */
    public void OnMessage(Long userID, Long teamID, Session client, String message) {
        
    }
    
    /**
     *
     * @param userID
     * @param teamID
     * @param client
     */
    public void OnClose(Long userID, Long teamID, Session client) {
        
    }
    
    /**
     *
     * @param userID
     * @param teamID
     * @param client
     */
    public void OnOpen(Long userID, Long teamID, Session client) {
        
    }
    
    /**
     *
     * @param t
     */
    public void OnError(Throwable t) {
        
    }
    
    /**
     *
     * @param UserID
     * @param message
     */
    public void SendMessageToUser(long UserID, Object message) {
        
    }
    
    /**
     *
     * @param TeamID
     * @param message
     */
    public void SendMessageToTeam(long TeamID, Object message) {
        
    }
    
    /**
     *
     * @param message
     */
    public void SendMessageToSpectator(Object message) {
        
    }
    
    /**
     *
     * @param message
     */
    public void SendMessageToParticipant(Object message) {
        
    }
}
