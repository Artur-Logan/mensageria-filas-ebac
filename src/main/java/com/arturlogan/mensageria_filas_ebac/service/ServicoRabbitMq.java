package com.arturlogan.mensageria_filas_ebac.service;

import com.arturlogan.mensageria_filas_ebac.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoRabbitMq {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviaMensagem(String mensagem){
        rabbitTemplate.convertAndSend(RabbitMqConfig.NOME_EXCHANGE, "ebac.rota.mensagem", mensagem);
    }
}
