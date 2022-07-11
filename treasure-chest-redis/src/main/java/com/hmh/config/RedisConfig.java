package com.hmh.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;

/**
 * redis 序列化配置
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
//开启caching的支持
@EnableCaching
public class RedisConfig{

//    @Bean
//    @ConditionalOnMissingBean(name = "redisTemplate")
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        //Jackson2JsonRedisSerializer 替换默认序列化
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//
//        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
//        template.setConnectionFactory(redisConnectionFactory);
//        // key 的序列化规则
//        template.setKeySerializer(jackson2JsonRedisSerializer);
//        // value 的序列化规则
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.setHashKeySerializer(jackson2JsonRedisSerializer);
//        template.setHashValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//        return template;
//    }
    @Bean
    public RedisTemplate<String, Object> myRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        //jackson序列化器(不能反序列化)
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //该方法已弃用
        //om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
        //字符串序列化器
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        //key与hashkey的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        //value与hashvalue的序列化方式
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);

        return template;
    }

    @Bean
    @ConditionalOnMissingBean(StringRedisTemplate.class)
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
    /**
     * 申明缓存管理器，会创建一个切面（aspect）并触发Spring缓存注解的切点（pointcut）
     * 根据类或者方法所使用的注解以及缓存的状态，这个切面会从缓存中获取数据，
     * 将数据添加到缓存之中或者从缓存中移除某个值
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        // 配置序列化（解决乱码的问题）
        //对key的序列化操作：String
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        //对value的序列化操作：json
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer =
                new GenericJackson2JsonRedisSerializer();
        //配置config,指定超时时间记得key val 序列化处理
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                //指定全局超时时间【60S】
                .entryTtl(Duration.ofSeconds(60))
                //配置key的序列化方式
                .serializeKeysWith(RedisSerializationContext
                        .SerializationPair
                        .fromSerializer(redisSerializer))
                //配置value的序列化方式
                .serializeValuesWith(RedisSerializationContext
                        .SerializationPair
                        .fromSerializer(genericJackson2JsonRedisSerializer))
                //关闭空值的存储
                .disableCachingNullValues();

        //使用建造者进行初始化
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(config)
                .build();
    }
}

