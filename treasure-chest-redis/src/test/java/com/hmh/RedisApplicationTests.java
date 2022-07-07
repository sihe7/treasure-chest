package com.hmh;

import com.hmh.utils.RedisManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

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
        redisTemplate.opsForValue().set("name","tom");
    }

}
