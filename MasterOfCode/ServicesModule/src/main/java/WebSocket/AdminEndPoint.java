package WebSocket;

import MessageUtils.MessageDecoder;
import MessageUtils.MessageEncoder;
import Service.CommunicationBean;
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
import javax.inject.Inject;
import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
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

    @Inject
    private CommunicationBean communicationBean;

    private final HashMap<String, Session> sessions = new HashMap<>();

    /**
     *
     * @param endpointConfig
     * @param session
     */
    @OnOpen
    public void onOpen(EndpointConfig endpointConfig, Session session) {
        System.out.println("Session opened!!!");
    }

    /**
     *
     * @param session
     * @param message
     */
    @OnMessage
    public void onMessage(final Session session, final BaseMessage message) {
        if (message instanceof NewSessionConnectionMessage) {
            this.addSession(session, (NewSessionConnectionMessage) message);
        } else {
            System.out.println("Message received: " + message.getClass() + "!!!");
            message.doAction(communicationBean);
        }
    }

    private void addSession(Session session, NewSessionConnectionMessage mess) {
        this.sessions.put(mess.getUsername(), session);
        System.out.println("Number of sessions: " + sessions.size());
    }

    /**
     *
     * @param username
     * @param message
     */
    public void sendMessage(String username, Object message) {
        try {
            System.out.println("Username to be found: " + username);
            System.out.println("All usernames in the sessions:");
            for (Map.Entry<String, Session> entry : sessions.entrySet()) {
                System.out.println("* Username: " + entry.getKey());
            }
            
            Session ses = sessions.get(username);
//            Basic basicObj = ses.getBasicRemote();
//            System.out.println("Is basic obj null: " + (basicObj == null));
            System.out.println("Is session null: " + (ses == null));
            System.out.println("Is message null: " + (message == null));
            ses.getBasicRemote().sendObject(message);
            System.out.println("Message send!!!");
        } catch (IOException | EncodeException | NullPointerException ex) {
            System.out.println("Exception: " + ex.getMessage());
            Logger.getLogger(AdminEndPoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendToAll(Object message) {
        for (String username : sessions.keySet()) {
            try {
                sessions.get(username).getBasicRemote().sendObject(message);
            } catch (IOException | EncodeException ex) {
                Logger.getLogger(CompetitorEndPoint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        Logger.getLogger(AdminEndPoint.class.getName()).log(Level.SEVERE, "An error occured in session " + session, error);
    }

    /**
     *
     * @param session
     * @param reason
     */
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
