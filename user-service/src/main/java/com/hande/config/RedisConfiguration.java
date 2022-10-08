package com.hande.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableCaching   //spring ya da java için önbelleklemeyi aktif etmek için kullanılır
@EnableRedisRepositories  // spring-redis için repositoryleri aktif etmek için kullanılır
public class RedisConfiguration {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory(){  //redis artık localhostta 6379 portuna bağlanacak yani redis artık aktif
        return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost",6379));
    }


}
