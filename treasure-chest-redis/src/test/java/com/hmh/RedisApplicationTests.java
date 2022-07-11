package com.hmh;

import com.hmh.utils.RedisManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
@Slf4j
@SpringBootTest
public class RedisApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisManager redisManager;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Test
    public void contextLoads() {
        redisTemplate.opsForValue().set("name","何猛");
    }

}
