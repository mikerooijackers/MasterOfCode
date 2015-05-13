
package Sockets;

import MessageUtils.MessageDecoder;
import MessageUtils.MessageEncoder;
import Messages.BaseMessage;
import Messages.HintMessage;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(
        value = "/adminEndpoint",
        encoders = {MessageEncoder.class},
        decoders = {MessageDecoder.class}
)
public class AdminEndpoint {
    private static final Logger LOG = Logger.getLogger(AdminEndpoint.class.getName());
    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public void onMessage(final Session client, final String message) {
    }

    private void sendMessage(Session session, Object send) {

        try {
            if (session.isOpen()) {
                session.getBasicRemote().sendObject(send);
            }
        } catch (IOException | EncodeException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @OnOpen
    public void onOpen(Session session) throws IOException, EncodeException {
        LOG.info("Connection opened ...");
        sessions.add(session);
        BaseMessage test = new HintMessage("TEST");
        session.getBasicRemote().sendObject(test);
    }

    @OnClose
    public void onClose(Session session) {
        LOG.info("Connection closed ...");
        sessions.remove(session);
    }

    @OnError
    public void onError(Throwable t) {
        LOG.log(Level.INFO, "Foutje ...{0}", t.getMessage());
    }
}
