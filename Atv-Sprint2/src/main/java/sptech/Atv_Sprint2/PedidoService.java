package sptech.Atv_Sprint2;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

public class PedidoService package sptech.Atv_Sprint2;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {

    private final RabbitTemplate rabbitTemplate;

    public MensagemService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarMensagem(Mensagem mensagem) {
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, mensagem);
        System.out.println("Mensagem enviada: " + mensagem.getConteudo());
    }
}{
}
