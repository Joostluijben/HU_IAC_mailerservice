import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(5672);

        String tomail = "joost.luijben@student.hu.nl";

        Connection connection = factory.newConnection();
        Listener.listenToChannel("oranje", connection, tomail);
        Listener.listenToChannel("rood", connection, tomail);
        Listener.listenToChannel("geel", connection, tomail);


    }
}
