package sptech.Atv_Sprint2;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mensagens")
public class ProdutorController {

    private final RabbitTemplate rabbitTemplate;

    public ProdutorController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public ResponseEntity<String> enviarMensagem(@RequestBody Mensagem mensagem) {
        // Fanout exchange: routing key vazia
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "", mensagem);
        return ResponseEntity.ok("Mensagem enviada com sucesso!");
    }
}
