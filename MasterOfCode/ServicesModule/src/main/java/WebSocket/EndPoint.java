/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebSocket;

import MessageUtils.MessageDecoder;
import MessageUtils.MessageEncoder;
import Sockets.Configurator;
import Sockets.Messages.BaseMessage;
import Sockets.Messages.HintMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author JordiK
 */
@ServerEndpoint(
        value = "/contestantSocket",
        encoders = {MessageEncoder.class},
        decoders = {MessageDecoder.class},
        configurator = Configurator.class
)
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Singleton
public class EndPoint {

    private HashMap<String, Session> sessions = new HashMap<>();

    @OnOpen
    public void onOpen(EndpointConfig endpointConfig, Session session) {
        this.sessions.put(session.getId(), session);
        try {
            session.getBasicRemote().sendObject(new HintMessage("This is a new hintMessage. Badum tss"));
        } catch (IOException | EncodeException ex) {
            Logger.getLogger(EndPoint.class.getName()).log(Level.SEVERE, null, ex);
        }
        Logger.getLogger(EndPoint.class.getName()).log(Level.INFO, null, String.format("onOpen: endpointConfig: {0}, session: {1}", endpointConfig, session));
    }

    @OnMessage
    public void onMessage(final Session session, final BaseMessage message) {
        message.doAction();
    }

    public void sendMessage(String username, Object message) {
        try {
            sessions.get(username).getBasicRemote().sendObject(message);
        } catch (IOException ex) {
            Logger.getLogger(EndPoint.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EncodeException ex) {
            Logger.getLogger(EndPoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        Logger.getLogger(EndPoint.class.getName()).log(Level.SEVERE, "An error occured in session " + session, error);
    }
    
    @OnClose
    public void onClose(Session session, CloseReason reason) {
        Logger.getLogger(EndPoint.class.getName()).log(Level.INFO, "Session {0} was closed with reason {1}", new Object[]{session, reason});
    }
}
