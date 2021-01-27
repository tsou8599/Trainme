package mail;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMailer {

    private Session session =  null;

    final String user = "51ff80b63340d0";
    final String password = "2efa1237ed4d07";
    final String host = "smtp.mailtrap.io";

    public JavaMailer() {
        init();
    }

    public boolean sendMail(String to, String subject, String content){
        //Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            // 設定內容物的類型是文字檔，必且使用UTF-8
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            // 設定要寄給誰
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // 設定信件標題
            message.setSubject(subject,"UTF-8");
            // 設定信件內容
            message.setContent(content,"text/html;charset=UTF-8");
            
            

            //send the message
            Transport.send(message);

            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void init() {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");

        this.session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });
    }
}