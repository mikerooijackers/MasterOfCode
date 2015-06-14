/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.main;

import java.io.Serializable;

/**
 *
 * @author Gebruiker
 */
public interface OperationDrivenMessage {
    public Serializable generateReplyMessage();
}
