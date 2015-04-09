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
import mocjms.messaging.requestreply.IRequestListener;
import mocjms.messaging.requestreply.IRequestReplySerializer;

/**
 *
 * @author Gebruiker
 */
public class AsynchronousReplierFAF<REQUEST, REPLY> {
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
    private IRequestListener<REQUEST> requestListener = null;
    
    /**
     * This constructor:
     * 1. intitiates the serializer, receiver and activeRequests
     * 2. registeres a message listener for the MessagingGateway (method onMessage)
     * @param requestReceiverQueue is the name of teh JMS queue from which the requests
     *        will be received.
     * @param serializer  used to de-serialize REQUESTs and serialize REPLIES.
     */
    public AsynchronousReplierFAF(String requestReceiverQueue, String replySenderQueue, IRequestReplySerializer<REQUEST, REPLY> serializer) throws Exception {
        super();
        this.serializer = serializer;
        gateway = new MessagingGateway(replySenderQueue, requestReceiverQueue); // other way around
        gateway.setListener(new MessageListener() {

            public void onMessage(Message message) {
                onRequest((TextMessage) message);
            }
        });
    }
    
    /**
     * sets the listener that will be notified when each request arriives
     * @param requestListener
     */
    public void setRequestListener(IRequestListener<REQUEST> requestListener) {
        this.requestListener = requestListener;
    }

    /**
     * Opens the jms connection of the Messaging Gateway in order to start sending/receiving requests.
     */
    public void start() {
        gateway.openConnection();
    }

    /**
     * This method is invoked every time a new request arrives
     * @todo Implement this method. It should:
     * 1. de-serialize the message into a REQUEST
     * 2. register the message to belong to the REQUEST
     * 3. notify the listener about the REQUEST arrival
     * @param message the incomming message containing the request
     */
    private synchronized void onRequest(TextMessage message) {
        try {
            REQUEST request = serializer.requestFromString(message.getText());
            requestListener.receivedRequest(request);
        } catch (JMSException ex) {
            Logger.getLogger(AsynchronousReplierFAF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Sends the reply for a specific request.
     * @todo implement the following:
     * 1. get the requestMessage registered for the request from activeRequests
     * 2. serialize the reply and create the replyMessage for it
     * 3. set the JMSCorrelationID of the replyMessage to be equal to the JMSMessageID of the requestMessage
     * 4. get the getJMSReplyTo destination of the requestMessage
     * 5. send the replyMessage to this Destination; use method send(Message m, Destination d) in MessagingGateway
     *
     * @param request to which this reply belongs
     * @param reply to the request
     * @return  true if the reply is sent succefully; false if sending reply fails
     */
    public synchronized boolean sendReply(REPLY reply) {
        String replyString = serializer.replyToString(reply);
        Message replyMessage = gateway.createMsg(replyString);       
        
        return gateway.send(replyMessage);
    }
}
