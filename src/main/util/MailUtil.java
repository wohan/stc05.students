package main.util;

import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by User on 15.04.2017.
 */
public class MailUtil {

    private static final Logger LOGGER = Logger.getLogger(MailUtil.class);

    public static void send(String email, String msg){

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("innostc@gmail.com", "Az123456");
                        }
                    });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("innostc@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(email));
                message.setSubject("STC05-STUDENTS");
                message.setText(msg);

                Transport.send(message);

            } catch (MessagingException e) {
                LOGGER.warn("Ошибка при отправке сообщения" + e);
            }

        LOGGER.info("Успешная отправка сообщения");
    }
}
