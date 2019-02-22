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

        Connection connection = factory.newConnection();
        Listener.listenToChannel("oranje", connection);
        Listener.listenToChannel("rood", connection);
        Listener.listenToChannel("geel", connection);


    }
}
