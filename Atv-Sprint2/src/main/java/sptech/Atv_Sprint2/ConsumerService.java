package sptech.Atv_Sprint2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class ConsumerService {
    @RabbitListener(queues = "${broker.queue.name}")
    public void receive(String message) {
        System.out.println("Received message: " + message);
    }
}
