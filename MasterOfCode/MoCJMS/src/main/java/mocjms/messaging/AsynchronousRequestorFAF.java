/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messaging;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import mocjms.messaging.requestreply.IRequestReplySerializer;

/**
 *
 * @author Gebruiker
 */
public class AsynchronousRequestorFAF<REQUEST, REPLY> {
    /**
     * For sending and receiving messages
     */
    private MessagingGateway gateway;
    
    /**
     * The serializer for domain classes REQUEST and REPLY
     */
    private IRequestReplySerializer<REQUEST, REPLY> serializer = null;
    /**
     * The listener that will be informed when each request arrives.
     */
    private IReplyListenerFAF<REPLY> replyListener = null;
    
    public AsynchronousRequestorFAF(String requestSenderQueue, String replyReceiverQueue, IRequestReplySerializer<REQUEST, REPLY> serializer) throws Exception {
        super();
        this.serializer = serializer;

        gateway = new MessagingGateway(requestSenderQueue, replyReceiverQueue);
        gateway.setListener(new MessageListener() {

            public void onMessage(Message message) {
                onReply((TextMessage) message);
            }
        });
    }
    
    public void setReplyListener(IReplyListenerFAF<REPLY> replyListener) {
        this.replyListener = replyListener;
    }
    
    /**
     * Opens JMS connection in order to be able to send messages and to start
     * receiving messages.
     */
    public void start() {
        gateway.openConnection();
    }

    /**
     * @todo implement this method!
     * Sends one request. Immediately, a listener is registered for this request.
     * This listener will be notified when (later) a reply for this request arrives.
     * This method should:
     * 1. create a Message for the request (use serializer).
     * 2. set the JMSReplyTo of the Message to be the Destination of the gateway's receiver.
     * 3. send the Message
     * 4. register the listener to belong to the JMSMessageID of the request Message
     * 
     * @param request is the request object (a domain class) to be sent
     * @param listener is the listener that will be notified when the reply arrives for this request
     */
    public synchronized void sendRequest(REQUEST request) {
        Message requestMessage = gateway.createMsg(serializer.requestToString(request));
        gateway.send(requestMessage);
    }

    /**
     * @todo implement this method!
     * This method is invoked for processing of a single reply when it arrives.
     * This method should be registered on the MessageReceiver.
     * This method should:
     * 1. get the registered listener fo the JMSCorrelationID of the Message
     * 2. de-serialize the REPLY from the Message
     * 3. notify the listener about the arrival of the REPLY
     * 4. unregister the listener
     * @param message the reply message
     */
    private synchronized void onReply(TextMessage message) {
        try {
            REPLY reply = serializer.replyFromString(message.getText());
            replyListener.receivedReply(reply);
        } catch (JMSException ex) {
            Logger.getLogger(AsynchronousRequestorFAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
