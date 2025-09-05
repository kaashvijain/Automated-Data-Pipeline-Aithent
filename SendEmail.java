import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import javax.activation.*;
import java.io.IOException;

public class SendEmail {

    public static void main(String[] args) {

        String filePath = null;
        try {
            filePath = ExportProcedure.ExportFile(); // method to export file
        } catch (Exception e) {
            System.out.println("Failed to export file.");
            e.printStackTrace();
            return; 
        }

        //smtp server
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.port", "587"); 
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.starttls.enable", "true"); 

        //login
        final String username = "xxxx@gmail.com"; //your email address
        final String password = "xxxx xxxx xxxx xxxx"; //your app password

        //authenticate
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            //message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("xxxx@gmail.com"));

            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("yyyy@gmail.com") //to reciever email address
            );

            message.setRecipients(
                    Message.RecipientType.CC,
                    InternetAddress.parse("zzzz@gmail.com") // cc reciever email address
            );

            message.setSubject("Exported File");

            // Body of the email 
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("message body text");

            // Attachment
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File(filePath));

            // Combining 
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }
}

