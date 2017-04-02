//package com.saras.template.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
///**
// * redis配置
// */
//@Configuration
//@EnableAutoConfiguration
//@EnableCaching
//public class RedisTemplateConfig extends CachingConfigurerSupport {
//	private final static Logger logger = LoggerFactory.getLogger(RedisTemplateConfig.class);
//
//
//    @Bean(name= "jedis.pool")
//    public JedisPool jedisPool(@Qualifier("jedis.pool.config") JedisPoolConfig config,
//                               @Value("${jedis.pool.host}")String host,
//                               @Value("${jedis.pool.port}")int port) {
//        return new JedisPool(config, host, port);
//    }
//
//
//    @Bean(name= "jedis.pool.config")
//    public JedisPoolConfig jedisPoolConfig (@Value("${jedis.pool.config.maxTotal}")int maxTotal,
//                                            @Value("${jedis.pool.config.maxIdle}")int maxIdle,
//                                            @Value("${jedis.pool.config.maxWaitMillis}")int maxWaitMillis) {
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxTotal(maxTotal);
//        config.setMaxIdle(maxIdle);
//        config.setMaxWaitMillis(maxWaitMillis);
//        return config;
//    }
//
//    @Bean
//	public JedisConnectionFactory getConnectionFactory() {
//		JedisConnectionFactory factory = new JedisConnectionFactory();
//		JedisPoolConfig config = new JedisPoolConfig();
//		config.setMaxIdle(8);
//		config.setMinIdle(0);
//		config.setMaxWaitMillis(10);
//		factory.setPoolConfig(config);
//		logger.info("JedisConnectionFactory bean init success.");
//		return factory;
//	}
//
//	@Bean
//	public RedisTemplate<?, ?> getRedisTemplate() {
//		return new StringRedisTemplate(getConnectionFactory());
//	}
////    @Bean
////    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
////
////        RedisTemplate<String,String> redisTemplate = new RedisTemplate<String, String>();
////
////        redisTemplate.setConnectionFactory(factory);
////
////
////
////        //key序列化方式;（不然会出现乱码;）,但是如果方法上有Long等非String类型的话，会报类型转换错误；
////
////        //所以在没有自己定义key生成策略的时候，以下这个代码建议不要这么写，可以不配置或者自己实现ObjectRedisSerializer
////
////        //或者JdkSerializationRedisSerializer序列化方式;
////
//////           RedisSerializer<String>redisSerializer = new StringRedisSerializer();//Long类型不可以会出现异常信息;
////
//////           redisTemplate.setKeySerializer(redisSerializer);
////
//////           redisTemplate.setHashKeySerializer(redisSerializer);
////
////
////
////        return redisTemplate;
////
////    }
//}
