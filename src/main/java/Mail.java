

import java.util.Properties;

import javax.mail.Session;

public class Mail {

    public static void sendMail(String message) {

        System.out.println("SimpleEmail Start");

        String smtpHostServer = "smtp.hu.nl";
        String emailID = "joost.luijben@student.hu.nl";

        Properties props = System.getProperties();

        props.put("mail.smtp.host", smtpHostServer);

        Session session = Session.getInstance(props, null);

        EmailUtil.sendEmail(session, emailID, "SimpleEmail Testing Subject", message);
    }

}
