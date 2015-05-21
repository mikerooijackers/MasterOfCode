package WebSocket;

import MessageUtils.MessageDecoder;
import MessageUtils.MessageEncoder;
import Sockets.Configurator;
import Sockets.Messages.BaseMessage;
import Sockets.Messages.NewSessionConnectionMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

@ServerEndpoint(
        value = "/adminSocket",
        encoders = {MessageEncoder.class},
        decoders = {MessageDecoder.class},
        configurator = Configurator.class
)
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Singleton
public class AdminEndPoint {

    private final HashMap<String, Session> sessions = new HashMap<>();

    @OnOpen
    public void onOpen(EndpointConfig endpointConfig, Session session) {
        System.out.println("Session opened!!!");
    }

    @OnMessage
    public void onMessage(final Session session, final BaseMessage message) {
        if (message instanceof NewSessionConnectionMessage) {
            this.addSession(session, (NewSessionConnectionMessage) message);
        } else {
            message.doAction();
        }
    }

    private void addSession(Session session, NewSessionConnectionMessage mess) {
        this.sessions.put(mess.getUsername(), session);
    }

    public void sendMessage(String username, Object message) {
        try {
            sessions.get(username).getBasicRemote().sendObject(message);
        } catch (IOException | EncodeException ex) {
            Logger.getLogger(AdminEndPoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        Logger.getLogger(AdminEndPoint.class.getName()).log(Level.SEVERE, "An error occured in session " + session, error);
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        System.out.println("Closing session");
        String usernameToRemove = "";
        for (Map.Entry<String, Session> entry : sessions.entrySet()) {
            String username = entry.getKey();
            Session sess = entry.getValue();
            
            if (sess == session) {
                usernameToRemove = username;
                break;
            }
        }
        if (!usernameToRemove.equals("")) {
            sessions.remove(usernameToRemove);
        }
        System.out.println("Sessions size: " + sessions.size());
    }
}