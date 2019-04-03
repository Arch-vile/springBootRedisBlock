package com.nakoradio.puuhamaa.springbootredisblock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisRestController {

  @Autowired
  ReactiveStringRedisTemplate redisTemplate;

  @GetMapping("/simple")
  public String simple() {
    return redisTemplate.opsForValue().get("/simple").block();
  }


}