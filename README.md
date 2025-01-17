# RabbitMQ com Spring Boot 🚀

Este projeto é uma aplicação que demonstra a utilização de filas no *RabbitMQ* com *Spring Boot*. Ele é configurado para gerenciar filas e exchanges de mensagens, utilizando práticas modernas de desenvolvimento e integração com serviços de mensageria.

---

## 📝 Funcionalidades

- 📤 *Envio de mensagens para filas RabbitMQ*;
- 📥 *Consumo de mensagens de filas RabbitMQ*;
- 🔗 *Configuração de exchanges e bindings*;
- 📄 Demonstração prática de filas e mensagens com *RabbitMQ* usando *Spring Boot*;
- 📊 Integração com o painel de gerenciamento do RabbitMQ para monitorar filas e mensagens.

---

## 🔧 Tecnologias Utilizadas

As principais tecnologias usadas neste projeto são:

- *Java 17*: Linguagem de programação principal;
- *Spring Boot 3.0+*: Framework para construção da aplicação;
  - *Spring AMQP*: Para integração com RabbitMQ;
  - *Spring Data*: Para manipulação de dados;
- *RabbitMQ 3.11*: Sistema de mensageria;
- *Docker*: Para executar o RabbitMQ com facilidade;
- *Postman*: Para testes de APIs e simulação de envio de mensagens.

---

## 🚀 Como Rodar o Projeto

### Pré-requisitos

- *Java 17* instalado;
- *Maven* configurado;
- *Docker* instalado e configurado.

### Passos

1. Clone este repositório:

bash
   git clone https://github.com/Artur-Logan/mensageria-filas-ebac.git
   cd mensageria-filas-ebac

2. Suba o RabbitMQ no Docker:

bash
   docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.11-management


3.Configure o arquivo application.properties:

Certifique-se de que as configurações do RabbitMQ estão corretas. Aqui está um exemplo de configuração:

bash
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest


4. Compile e execute o projeto:

bash
mvn spring-boot:run


5. Acesse o painel do RabbitMQ:

- URL: http://localhost:15672
- Usuário: guest
- Senha: guest

---
## 📦 Estrutura do Projeto
```plaintext

src
├── main
│   ├── java
│   │   └── com.arturlogan.mensageria_filas_ebac
│   │       ├── controllers  # Contém os endpoints da API
│   │       ├── config       # Configurações do RabbitMQ
│   │       ├── services     # Serviços que processam mensagens
│   │       ├── entities     # Modelos de dados
│   │       └── repositories # Manipulação do banco de dados
│   └── resources
│       └── application.properties # Configurações do Spring Boot
```

---

## 📄 Documentação das APIs

**Enviar mensagem para uma fila**

- *Endpoint*: /mensagens
- *Método*: POST
- *Corpo*: Text
  ```plaintext
  Olá mundo!
  ```
- *Resposta*: Status Code 200(OK)

---

## 🛠 Principais Configurações

**Configuração de RabbitMQ**

A configuração do RabbitMQ está no arquivo *RabbitMqConfig* dentro do pacote *config*:

```java
@Configuration
public class RabbitMqConfig {

    public static final String NOME_FILA = "fila-ebac";
    public static final String NOME_EXCHENGE = "exchange.ebac";
    public static final String NOME_ROTA = "ebac.rota.#";

    @Bean
    public Queue queue() {
        return new Queue(NOME_FILA, false);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(NOME_EXCHENGE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(NOME_ROTA);
    }
}

```
- *Fila (Queue)*: Nome da fila utilizada para enviar e consumir mensagens.
- *Exchange*: Nome do exchange responsável pelo roteamento das mensagens.
- *Binding*: Define a relação entre a fila e o exchange usando uma rota específica.

---

## 🤝 Contribuições

Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

1. Faça um fork do repositório.
2. Crie uma branch para sua funcionalidade (git checkout -b feature/nova-funcionalidade).
3. Faça commit das alterações (git commit -m 'Adicionei nova funcionalidade').
4. Faça push para a branch (git push origin feature/nova-funcionalidade).
5. Abra um Pull Request.

---

## 📝 Licença

Este projeto está licenciado sob a MIT License. Para mais detalhes, veja o arquivo LICENSE.

---

## 📞 Contato

Se tiver dúvidas ou sugestões, entre em contato:

- Nome: Artur Logan

- [LinkedIn](https://www.linkedin.com/in/arturlogan/)

- E-mail: arturlogan1ferreira@gmail.com

