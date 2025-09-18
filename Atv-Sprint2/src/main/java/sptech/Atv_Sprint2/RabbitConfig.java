package sptech.Atv_Sprint2;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    
    public static final String QUEUE_NAME = "mensagens";
    public static final String EXCHANGE_NAME = "mensagens.exchange";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange());
    }
}