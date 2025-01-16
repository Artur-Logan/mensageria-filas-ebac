package com.arturlogan.mensageria_filas_ebac.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String NOME_FILA = "fila-ebac"; // Nome da fila
    public static final String NOME_EXCHANGE = "exchange.ebac"; // Nome da exchange
    public static final String NOME_ROTA = "ebac.rota.#"; // Nome da rota

    // Declaração da fila
    @Bean
    public Queue queue() {
        return new Queue(NOME_FILA, true); // Define a fila como persistente
    }

    // Declaração da exchange
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(NOME_EXCHANGE);
    }

    // Binding entre fila, exchange e rota
    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(NOME_ROTA);
    }
}
