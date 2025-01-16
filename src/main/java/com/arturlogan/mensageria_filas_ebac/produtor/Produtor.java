package com.arturlogan.mensageria_filas_ebac.produtor;

import com.arturlogan.mensageria_filas_ebac.service.ServicoRabbitMq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensagens")
public class Produtor {

    @Autowired
    private ServicoRabbitMq servicoRabbitMq;

    @PostMapping
    public void enviaMensagem(@RequestBody String mensagem){
        System.out.println("=================== Enviando Mensagem ==================");

        servicoRabbitMq.enviaMensagem(mensagem);
    }
}
