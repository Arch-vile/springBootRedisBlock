package com.nakoradio.puuhamaa.springbootredisblock;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;

@SpringBootApplication
public class SpringbootredisblockApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootredisblockApplication.class, args);
	}


	@Bean
	public ReactiveRedisConnectionFactory lettuceConnectionFactory( ) {
		return new LettuceConnectionFactory();
	}

	@Bean
	ReactiveStringRedisTemplate reactiveRedisTemplate(
			@Qualifier("lettuceConnectionFactory") ReactiveRedisConnectionFactory factory) {
		return new ReactiveStringRedisTemplate(factory);
	}
}
