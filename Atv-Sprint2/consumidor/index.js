const express = require('express');
const amqp = require('amqplib');

const app = express();
const PORT = 3000;

// Array para guardar mensagens
let mensagens = [];

// Conectar ao RabbitMQ
async function conectarRabbitMQ() {
    try {
        const connection = await amqp.connect('amqp://myuser:secret@localhost:5672');
        const channel = await connection.createChannel();
        
        const exchange = 'mensagens.exchange';
        const queue = 'mensagens';
        
        await channel.assertExchange(exchange, 'fanout', { durable: true });
        await channel.assertQueue(queue, { durable: true });
        await channel.bindQueue(queue, exchange, '');

        console.log('Aguardando mensagens...');
        
        channel.consume(queue, (msg) => {
            if (msg) {
                const mensagem = JSON.parse(msg.content.toString());
                mensagem.timestamp = new Date().toISOString();
                mensagens.push(mensagem);
                
                console.log('Mensagem recebida:', mensagem.conteudo);
                channel.ack(msg);
            }
        });
        
    } catch (error) {
        console.error('Erro:', error.message);
        setTimeout(conectarRabbitMQ, 5000);
    }
}

// Endpoint para ver mensagens
app.get('/mensagens', (req, res) => {
    res.json(mensagens);
});

app.listen(PORT, () => {
    console.log(`Consumidor rodando na porta ${PORT}`);
    conectarRabbitMQ();
});