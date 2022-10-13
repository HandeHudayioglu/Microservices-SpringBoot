package com.hande.rabbitmq.consumer;

import com.hande.rabbitmq.model.CreateUser;
import com.hande.repository.entity.UserProfile;
import com.hande.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateUserConsumer {

    private final UserProfileService userProfileService;

    @RabbitListener(queues = "queue-auth-create-user")
    public void createUserMessageConsumer(CreateUser user){
        log.info("User received: {}", user.toString());
        userProfileService.save(UserProfile.builder()
                        .email(user.getEmail())
                        .userName(user.getUserName())
                        .authId(user.getAuthId())
                .build());
    }
}
