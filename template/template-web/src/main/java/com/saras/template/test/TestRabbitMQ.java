package com.saras.template.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.saras.template.config.RabbitMQConfig;
import com.saras.template.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * description:
 * saras_xu@163.com 2017-04-05 09:17 创建
 */
@Component
public class TestRabbitMQ {
    private final static Logger logger = LoggerFactory.getLogger(TestRabbitMQ.class);


    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = RabbitMQConfig.QUEUE, durable = "true"),
            exchange = @Exchange(value = RabbitMQConfig.EXCHANGE, durable = "true", type = ExchangeTypes.FANOUT)),
            containerFactory = "rabbitListenerContainerFactory")
    public void handle(Message msg) {
        try {
            byte[] bytes = msg.getBody();
            String userString = JSONObject.parseObject(bytes, String.class, Feature.OrderedField);
            User user = JSON.parseObject(userString, User.class);
            logger.info("获取到RabbitMQ消息：{}", user);
        } catch (Exception e) {
            logger.error("消息转换失败：", e);
        }
    }

}
