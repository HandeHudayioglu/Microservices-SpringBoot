package com.hande.rabbitmq.producer;

import com.hande.rabbitmq.model.CreateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class CreateUserProducer {

    /**
     * mesaj iletmek için rabbit template kullanıyoruz
     */

    private final RabbitTemplate rabbitTemplate;

    public void sendCreateUserMessage(CreateUser user){
        rabbitTemplate.convertAndSend("exchange-auth",
                        "key-auth", user);

    }
}
