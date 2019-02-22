import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;

public class Listener {
    public static void listenToChannel(String color, Connection connection, String tomail) throws IOException {
        Channel channel = connection.createChannel();

        channel.queueDeclare(color, false, false, false, null);
        System.out.println(" [*] Waiting for messages at channel " + color + ". To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            Mail.sendMail("code " + color + ": " + message, tomail);

        };
        channel.basicConsume(color, true, deliverCallback, consumerTag -> {
        });
    }
}
