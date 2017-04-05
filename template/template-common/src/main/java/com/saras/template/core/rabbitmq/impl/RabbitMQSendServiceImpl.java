package com.saras.template.core.rabbitmq.impl;

import com.saras.template.config.RabbitMQConfig;
import com.saras.template.core.rabbitmq.RabbitMQSendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * description:
 * saras_xu@163.com 2017-04-05 09:11 创建
 */
@Component
public class RabbitMQSendServiceImpl implements RabbitTemplate.ConfirmCallback, RabbitMQSendService {
    private final static Logger logger = LoggerFactory.getLogger(RabbitMQSendServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 构造方法注入
     */
    public RabbitMQSendServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
    }

    @Override
    public void sendMsg(String message) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        logger.debug("correlationId：{}", correlationId);
        logger.info("message：{}", message);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTINGKEY, message, correlationId);
    }

    /**
     * 回调
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        logger.debug("回调ID：{}，ack：{}，cause", correlationData, ack, cause);
        if (ack) {
            logger.debug("消息消费成功");
        } else {
            logger.debug("消息消费失败：{}", cause);
        }
    }
}
