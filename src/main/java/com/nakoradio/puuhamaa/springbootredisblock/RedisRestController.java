package com.nakoradio.puuhamaa.springbootredisblock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisRestController {

  @Autowired
  ReactiveStringRedisTemplate reactiveTmpl;

  @GetMapping("/simple")
  public String simple() {
    return reactiveTmpl.opsForValue().get("/value1").block();
  }


  @GetMapping("/nested")
  public String nested() {
    return reactiveTmpl.opsForValue().get("/value1")
        .map(it -> reactiveTmpl.opsForValue().get("/value1").block())
        .block();
  }
}