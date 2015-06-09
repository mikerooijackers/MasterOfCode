/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.request;

import mocjms.messages.main.OperationDrivenReplyMessage;
import mocjms.messages.main.OperationDrivenRequestMessage;

/**
 * @deprecated This is now supported by the main server. No JMS is involved.
 * @author Gebruiker
 */
@Deprecated
public class ReadMetaDataRequestMessage extends OperationDrivenRequestMessage {
    private Long assignmentId;

    public ReadMetaDataRequestMessage(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public ReadMetaDataRequestMessage() {
    }

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    @Override
    public OperationDrivenReplyMessage generateReplyMessage() {
        return null;
        //WorkspaceService.getInstance().readAssignmentMetaData(null, assignmentId)
    }
}
