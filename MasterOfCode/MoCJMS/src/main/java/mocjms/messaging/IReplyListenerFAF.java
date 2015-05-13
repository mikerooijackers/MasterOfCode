/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messaging;

import java.io.Serializable;

/**
 *
 * @author Gebruiker
 */
public interface IReplyListenerFAF {
    public void receivedReply(Serializable reply);
}
