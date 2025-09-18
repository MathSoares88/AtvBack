package sptech.Atv_Sprint2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProdutorApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProdutorApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(ProdutorService produtorService) {
        return args -> {
            Mensagem msg = new Mensagem("Olá RabbitMQ!", "Aluno");
            produtorService.enviarMensagem(msg);
        };
    }
}
