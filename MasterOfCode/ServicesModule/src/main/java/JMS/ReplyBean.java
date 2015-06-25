/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JMS;

import Service.CommunicationBean;
import Sockets.Messages.Client.Reply.GroupTestsReplyMessage;
import Sockets.Messages.Client.Reply.OtherTeamScoreReplyMessage;
import Sockets.Messages.Client.Reply.SubmitReplyMessage;
import Sockets.Messages.Client.Reply.UserTestsReplyMessage;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import mocjms.messages.reply.CompileReplyMessage;
import mocjms.messages.reply.CreateWorkspaceReplyMessage;
import mocjms.messages.reply.DeleteWorkspaceReplyMessage;
import mocjms.messages.reply.EditSourceCodeReplyMessage;
import mocjms.messages.reply.ExtractAssignmentToWorkspacesReplyMessage;
import mocjms.messages.reply.GetSourceCodeFilesReplyMessage;
import mocjms.messages.reply.GroupTestReplyMessage;
import mocjms.messages.reply.TurninReplyMessage;
import mocjms.messages.reply.UserTestReplyMessage;


/**
 *
 * @author mikerooijackers
 */
@MessageDriven(mappedName = "jms/MasterOfCode/ReplyQueue")
public class ReplyBean implements MessageListener {
    
    @Inject
    private JMSManager manager;
    
    @EJB
    private CommunicationBean communicationBean;
    
    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            try {
                System.out.println("[[INFO]] JMS message received!");
                ObjectMessage objectMessage = (ObjectMessage) message;
//                long teamId = -1L; 
//                
//                try {
//                    teamId = objectMessage.getLongProperty("teamId");
//                } catch (JMSException ex) {
//                    Logger.getLogger(ReplyBean.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
                Serializable object = objectMessage.getObject();
                
                if (object instanceof CompileReplyMessage) {
                    System.out.println("[[INFO]] Compile reply message received");
                    CompileReplyMessage jmsMessage = (CompileReplyMessage) object;
                    Sockets.Messages.Client.Reply.CompileReplyMessage replyMessage = new Sockets.Messages.Client.Reply.CompileReplyMessage(jmsMessage.getResult(), jmsMessage.getTeamId());
                    communicationBean.sendMessageToCompetitor(jmsMessage.getTeamId(), replyMessage);
                } else if (object instanceof CreateWorkspaceReplyMessage) {
                    System.out.println("[[INFO]] Create workspace reply message received");
                    // do nothing...
                } else if (object instanceof DeleteWorkspaceReplyMessage) {
                    System.out.println("[[INFO]] Delete workspace reply message received");
                    // do nothing...
                } else if (object instanceof EditSourceCodeReplyMessage) {
                    System.out.println("[[INFO]] Edit source code reply message received");
                    // do nothing...
                } else if (object instanceof ExtractAssignmentToWorkspacesReplyMessage) {
                    System.out.println("[[INFO]] Extract assignment to workspaces reply message received");
                    ExtractAssignmentToWorkspacesReplyMessage jmsMessage = (ExtractAssignmentToWorkspacesReplyMessage) object;
                    
                    communicationBean.sendRoundMetaData();
                    // do nothing...
                } else if (object instanceof GetSourceCodeFilesReplyMessage) {
                    System.out.println("[[INFO]] Get source code files reply message received");
                    GetSourceCodeFilesReplyMessage jmsMessage = (GetSourceCodeFilesReplyMessage) object;
                    
                    Sockets.Messages.Client.Reply.GetSourceFilesReplyMessage replyMessage = new Sockets.Messages.Client.Reply.GetSourceFilesReplyMessage(jmsMessage.getListSourceCode());
                    communicationBean.sendMessageToCompetitor(jmsMessage.getTeamId(), replyMessage);
                    // TODO
                } else if (object instanceof GroupTestReplyMessage) {
                    System.out.println("[[INFO]] Group test reply message received");
                    GroupTestReplyMessage jmsMessage = (GroupTestReplyMessage) object;
                    GroupTestsReplyMessage replyMessage = new GroupTestsReplyMessage(jmsMessage.getResult());
                    // TODO         communicationBean.sendMessageToCompetitor(jmsMessage.getTeamId(), replyMessage);
                } else if (object instanceof UserTestReplyMessage) {
                    System.out.println("[[INFO]] User test reply message received");
                    UserTestReplyMessage jmsMessage = (UserTestReplyMessage) object;
                    UserTestsReplyMessage replyMessage = new UserTestsReplyMessage(jmsMessage.getResult());
                    communicationBean.sendMessageToCompetitor(jmsMessage.getTeamId(), replyMessage);
                } else if (object instanceof TurninReplyMessage) {
                    System.out.println("[[INFO]] Turn in reply message received");
                    TurninReplyMessage jmsMessage = (TurninReplyMessage) object;
                    SubmitReplyMessage replyMessage = new SubmitReplyMessage(jmsMessage.getScore(), jmsMessage.isSucceeded());
                    communicationBean.sendMessageToCompetitor(jmsMessage.getTeamId(), replyMessage);
                    
                    if (jmsMessage.isSucceeded()) {
                        communicationBean.addScoreToTeam(jmsMessage.getTeamId(), jmsMessage.getScore());
                        communicationBean.sendTeamScore(jmsMessage.getTeamId(), jmsMessage.getScore());
                    }
                }
                
            } catch (JMSException ex) {
                Logger.getLogger(ReplyBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("reply received");
    }
}
