package com.arturlogan.mensageria_filas_ebac.consumidor;

import com.arturlogan.mensageria_filas_ebac.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitMqConfig.NOME_FILA)
public class Consumidor {

    @RabbitHandler
    public void consumirMensagem(String mensagem){
        System.out.println("============== RECEBENDO MENSAGEM =============");
        System.out.println("============================= " + mensagem);
        System.out.println("============== FIM RECEBENDO MENSAGEM =============");
    }


}
