package org.lizhao.amqp.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * Publisher Returns
 * returns always before confirm
 *
 * handle the messages which returned by broker when it can not deliver message according to the route.
 *
 * simple implementation : just log the returned message
 *
 * @author lizhao
 * @version 1.0
 * @ClassName MySendReturnCallback
 * @Date 2021-10-09 19:27
 * @since 1.8
 */
public class SimplePublisherReturnCallback implements RabbitTemplate.ReturnsCallback {

    private static final Logger log= LoggerFactory.getLogger(SimplePublisherReturnCallback.class);

    @Override
    public void returnedMessage(ReturnedMessage returned) {
        log.debug("publisher returns callback(can not find the queue): "
                +"\r\n"+"routeKey: "+returned.getRoutingKey()
                +"\r\n"+"exchangeName: "+returned.getExchange()
                +"\r\n"+"replyCode: "+returned.getReplyCode()
                +"\r\n"+"replyText: "+returned.getReplyText()
                +"\r\n"+"return message: "+returned.getMessage().toString()
        );
    }

}