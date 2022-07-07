package com.hmh;

import com.hmh.entity.User;
import com.hmh.utils.RedisManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;


/**
 * <p>
 * Redis测试
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-15 17:17
 */
@Slf4j
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisManager redisManager;

    @Autowired
    private RedisTemplate<String, Object> template;


    /**
     * 测试 Redis 操作
     * redisTemplate.opsForValue();//操作字符串
     * redisTemplate.opsForHash();//操作hash
     * redisTemplate.opsForList();//操作list
     * redisTemplate.opsForSet();//操作set
     * redisTemplate.opsForZSet();//操作有序set
     */
    @Test
    public void get() {

        // 测试线程安全，程序结束查看redis中count的值是否为1000
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0, 1000).forEach(i -> executorService.execute(() -> stringRedisTemplate.opsForValue().increment("count", 1)));

        stringRedisTemplate.opsForValue().set("k1", "v1");
        String k1 = stringRedisTemplate.opsForValue().get("k1");
        log.info("【k1】= {}", k1);

        // 以下演示整合，具体Redis命令可以参考官方文档
        String key = "xkcoding:user:1";
        template.opsForValue().set(key, new User(1L, "user1"));
        // 对应 String（字符串）
        User user = (User) template.opsForValue().get(key);
        log.info("【user】= {}", user);


    }

    @Test
    public void test01() {
        redisManager.insertObject("hemenghao", "a:b:c");
        redisManager.insertObject("hemenghao2", "a:b");
        redisManager.hPut("date", "20220607", "1");
        redisManager.hPut("date", "20220608", "1");
        redisManager.hPut("date", "20220609", "1");

        Map<String, Object> testMap = new HashMap<>();
        testMap.put("name", "jack");
        testMap.put("age", 27);
        testMap.put("class", "1");
        redisManager.hPutAll("redisHash1", testMap);

        redisManager.zadd("zset1", "zset-1", 1.0);
        redisManager.zadd("zset1", "zset-5", 1.2);
        redisManager.zadd("zset1", "zset-6", 1.1);
        redisManager.zadd("zset1", "zset-2", 2.0);
        redisManager.zadd("zset1", "zset-3", 3.0);
        redisManager.zadd("zset1", "zset-4", 4.0);

        System.out.println("=========================");
//        Set<Object> zset1 = redisManager.zRange("zset1", 0, -1);
//        for (Object next : zset1) {
//            System.out.println(next);
//        }


        System.out.println("==============================");
        ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<Object>("zset-5", 9.6);
        ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<Object>("zset-6", 9.9);
        Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<>();
        tuples.add(objectTypedTuple1);
        tuples.add(objectTypedTuple2);
        redisManager.zAdd("zset2", tuples);
        redisManager.zRange("zset2", 0, -1);
    }

    @Test
    public void test02() {
        System.out.println(redisManager.hasKey("s"));
        System.out.println(template.opsForList().range("list", 0, -1));
    }
}
