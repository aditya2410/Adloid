package com.adloid.webApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@ComponentScan("com.adloid.webApp")
public class RedisConfig {

    @Value("${redis.hostname}")
    private String hostname;
    @Value("${redis.port}")
    private int port ;
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("172.18.0.2", 6379);
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return template;
    }

}