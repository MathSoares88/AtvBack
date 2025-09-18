package sptech.Atv_Sprint2;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProdutorService {

    private final RabbitTemplate rabbitTemplate;

    public ProdutorService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarMensagem(Mensagem mensagem) {
        // Como é fanout, a routing key pode ser vazia
        rabbitTemplate.convertAndSend("", mensagem);
        System.out.println("Mensagem enviada: " + mensagem.getConteudo() + " por " + mensagem.getAutor());
    }
}
