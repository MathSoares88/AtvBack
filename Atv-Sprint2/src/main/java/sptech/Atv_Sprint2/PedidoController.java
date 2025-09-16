package sptech.Atv_Sprint2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @PostMapping
    public ResponseEntity<String> enviarMensagem(@RequestBody Mensagem mensagem) {
        mensagemService.enviarMensagem(mensagem);
        return ResponseEntity.ok("Mensagem enviada com sucesso!");
    }
}