package com.saras.template.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis配置
 */
@Configuration
@EnableAutoConfiguration
@EnableCaching
public class RedisTemplateConfig {
    private final static Logger logger = LoggerFactory.getLogger(RedisTemplateConfig.class);

    @Bean
    public JedisConnectionFactory getConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(50);
        config.setMinIdle(0);
        config.setMaxWaitMillis(1000);
        config.setMaxTotal(500);
        factory.setPassword("root123");
        factory.setHostName("127.0.0.1");
        factory.setPort(6379);
        factory.setTimeout(1000);
        factory.setDatabase(1);
        factory.setPoolConfig(config);
        logger.info("JedisConnectionFactory bean init success.");
        return factory;
    }

    @Bean
    public RedisTemplate<?, ?> getRedisTemplate() {
        return new StringRedisTemplate(getConnectionFactory());
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
        //设置缓存过期时间 可根据需求设置
        //rcm.setDefaultExpiration(60);//秒
        return rcm;

    }
}
