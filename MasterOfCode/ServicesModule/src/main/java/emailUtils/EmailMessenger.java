/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailUtils;

import java.util.List;
import java.util.Properties;
import javax.ejb.Singleton;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author JordiK
 */
@Singleton
public class EmailMessenger {

    private final String username = "masterofcodee@gmail.com";
    private final String password = "masterofcode";

    private void sendEmail(String addressTo, String subject, String mailContent) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(addressTo));
            message.setSubject(subject);
            message.setText(mailContent);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendAddedToTeamMessage(String addressTo, List<String> members, String teamName, String initiator) {
        String subject = "You have been added to a team!";
        String content = "Dear " + addressTo + ",";
        content += "\n" + "\n";
        content += "You have been added to a team for MasterOfCode! The name of this team is " + teamName + ".";
        content += "\n" + "\n";
        content += initiator + " has created this team and has added the following people: \n";
        for (String member : members) {
            if (!member.equals("")) {
                content += " - " + member + "\n";
            }
        }
        content += "\n";
        content += "Good luck in your coding endeavours!";
        this.sendEmail(addressTo, subject, content);
    }

}
