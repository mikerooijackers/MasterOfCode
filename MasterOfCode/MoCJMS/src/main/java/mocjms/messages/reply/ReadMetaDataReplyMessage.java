/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.reply;

import java.util.ArrayList;
import java.util.List;
import Domein.AnnotationData;
import mocjms.messages.main.CompetitionBasedOperationDrivenReplyMessage;

/**
 * @deprecated This is now supported by the main server. No JMS is involved.
 * @author Gebruiker
 */
@Deprecated
public class ReadMetaDataReplyMessage extends CompetitionBasedOperationDrivenReplyMessage {

    private AnnotationData assignmentMetaData;
    private List<AnnotationData> testsMetaData;

    public ReadMetaDataReplyMessage() {
        this.testsMetaData = new ArrayList<>();
    }

    public ReadMetaDataReplyMessage(AnnotationData assignmentMetaData, List<AnnotationData> testsMetaData) {
        this.assignmentMetaData = assignmentMetaData;
        this.testsMetaData = testsMetaData;
    }

    public AnnotationData getAssignmentMetaData() {
        return assignmentMetaData;
    }

    public void setAssignmentMetaData(AnnotationData assignmentMetaData) {
        this.assignmentMetaData = assignmentMetaData;
    }

    public List<AnnotationData> getTestsMetaData() {
        return testsMetaData;
    }

    public void setTestsMetaData(List<AnnotationData> testsMetaData) {
        this.testsMetaData = testsMetaData;
    }
}
