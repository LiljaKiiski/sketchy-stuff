// File Name SendEmail.java

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

   public static void main(String [] args) {    
      // Recipient's email ID needs to be mentioned.
      String to = "lilja.maria.kiiski@gmail.com";

      // Sender's email ID needs to be mentioned
      String from = "lilja.maria.kiiski@gmail.com";

      // Assuming you are sending email from localhost
      String host = "smtp.gmail.com";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try {
         MimeMessage message = new MimeMessage(session);

         message.setFrom(new InternetAddress(from));

         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         message.setSubject("Java Test");

         message.setText("Hey! This is Lilja! This message was sent with java :)");

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}
