package sptech.Atv_Sprint2;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String QUEUE_NAME = "pedidos-queue";
    public static final String EXCHANGE_NAME = "pedidos-exchange";
    public static final String ROUTING_KEY = "pedidos.novo";

    @Bean
    public Queue pedidosQueue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    @Bean
    public DirectExchange pedidosExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue pedidosQueue, DirectExchange pedidosExchange) {
        return BindingBuilder.bind(pedidosQueue).to(pedidosExchange).with(ROUTING_KEY);
    }
}









