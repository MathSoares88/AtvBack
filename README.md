Atv-Sprint2

Projeto feito para treinar comunicação entre aplicações usando RabbitMQ
De um lado temos o Spring Boot (Java) como produtor
Do outro, o Node.js como consumidor

A ideia é: o produtor manda mensagens e o consumidor recebe, guarda e mostra pra gente

Como funciona

Produtor (Spring Boot / Java)

Manda mensagens em JSON com conteudo e autor.

Usa RabbitMQ com exchange do tipo fanout.

Possui endpoints REST pra você disparar as mensagens.

Consumidor (Node.js)

Fica ouvindo a fila mensagens.

Guarda tudo em memória.

Tem uma rota HTTP /mensagens pra consultar o que já chegou.

RabbitMQ

Sobe via Docker Compose.


▶️ Como rodar
1. Subir o RabbitMQ
docker compose up -d

2. Rodar o Produtor (Java)
./mvnw spring-boot:run   # Linux
mvnw.cmd spring-boot:run # Windows

3. Rodar o Consumidor (Node.js)
cd consumidor
npm install
npm start

4. Enviar Mensagens
POST http://localhost:8080/mensagens
Content-Type: application/json

{
  "conteudo": "Olá, mundo!",
  "autor": "Seu Nome"
}

5. Ver Mensagens Recebidas

http://localhost:3000/mensagens



👩‍💻 Autores

Matheus Soares – 01241171
Mayara Damas – 01241009
