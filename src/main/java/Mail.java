

import java.util.Properties;

import javax.mail.Session;

public class Mail {

    public static void sendMail(String message, String tomail) {


        String smtpHostServer = "smtp.hu.nl";
        String emailID = tomail;

        Properties props = System.getProperties();

        props.put("mail.smtp.host", smtpHostServer);

        Session session = Session.getInstance(props, null);

        EmailUtil.sendEmail(session, emailID, "SimpleEmail Testing Subject", message);
    }

}
