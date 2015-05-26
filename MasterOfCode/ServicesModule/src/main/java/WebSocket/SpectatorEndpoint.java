/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebSocket;

import MessageUtils.MessageDecoder;
import MessageUtils.MessageEncoder;
import Service.CommunicationBean;
import Sockets.Configurator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author May
 */
@ServerEndpoint(
        value = "/spectatorSocket",
        encoders = {MessageEncoder.class},
        decoders = {MessageDecoder.class},
        configurator = Configurator.class
)

@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Singleton
public class SpectatorEndpoint {

    @Inject
    private CommunicationBean communicationBean;

    /**
     *
     * @param endpointConfig
     * @param session
     */
    @OnOpen
    public void onOpen(EndpointConfig endpointConfig, Session session) {
        System.out.println("Session opened");
    }

    /**
     *
     * @param message
     * @return
     */
    @OnMessage
    public String onMessage(String message) {
        return null;
    }
    
    public void sendMessage(Object message) {
        
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        Logger.getLogger(SpectatorEndpoint.class.getName()).log(Level.SEVERE, "An error occured in session " + session, error);
    }
    
    /**
     * 
     * @param session
     * @param reason 
     */
    @OnClose
    public void onClose(Session session, CloseReason reason) {
        
    }

}
