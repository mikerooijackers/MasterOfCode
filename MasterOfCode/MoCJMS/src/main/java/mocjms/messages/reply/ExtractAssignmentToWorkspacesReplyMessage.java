/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.reply;

import mocjms.messages.main.OperationDrivenReplyMessage;

/**
 *
 * @author Gebruiker
 */
public class ExtractAssignmentToWorkspacesReplyMessage extends OperationDrivenReplyMessage {
    private boolean isSuccesful;

    /**
     *
     * @param isSuccesful
     */
    public ExtractAssignmentToWorkspacesReplyMessage(boolean isSuccesful) {
        this.isSuccesful = isSuccesful;
    }

    /**
     *
     */
    public ExtractAssignmentToWorkspacesReplyMessage() {
    }

    /**
     *
     * @return
     */
    public boolean isIsSuccesful() {
        return isSuccesful;
    }

    /**
     *
     * @param isSuccesful
     */
    public void setIsSuccesful(boolean isSuccesful) {
        this.isSuccesful = isSuccesful;
    }
}
