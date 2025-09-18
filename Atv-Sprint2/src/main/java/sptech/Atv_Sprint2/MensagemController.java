package sptech.Atv_Sprint2;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class MensagemController {

    private final RabbitTemplate rabbitTemplate;

    public MensagemController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/mensagem")
    public String enviar(@RequestBody Mensagem mensagem) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "", mensagem);
        System.out.println("Mensagem enviada: " + mensagem.getConteudo());
        return "Mensagem enviada!";
    }
}