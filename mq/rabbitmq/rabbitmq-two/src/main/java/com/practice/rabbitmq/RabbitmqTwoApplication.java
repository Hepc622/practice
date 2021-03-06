package com.practice.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RabbitmqTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqTwoApplication.class, args);
    }

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @GetMapping("/send/{content}")
    public void send(@PathVariable("content")String content) {
        System.out.println("Sender : " + content);
        this.rabbitTemplate.convertAndSend(RabbitMqConfig.QUEUE_A, content);
    }

    @RabbitListener(queues = RabbitMqConfig.QUEUE_A)
    @RabbitHandler
    public void reserve(String message) {
        System.out.println(message);
    }
}

