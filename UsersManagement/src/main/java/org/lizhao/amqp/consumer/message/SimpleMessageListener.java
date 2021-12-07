package org.lizhao.amqp.consumer.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * simple implementation of {@link MessageListener}
 *
 *
 * @author lizhao
 * @version 1.0
 * @ClassName SimpleMessageListener
 * @Date 2021-10-12 17:55
 * @since 1.8
 */
public class SimpleMessageListener implements MessageListener {

    private static final Logger log= LoggerFactory.getLogger(SimpleMessageListener.class);

    @Override
    public void onMessage(Message message) {
        System.out.println(new String(message.getBody()));
        log.debug(new String(message.getBody()));
    }

    @Override
    public void containerAckMode(AcknowledgeMode mode) {

    }

    @Override
    public void onMessageBatch(List<Message> messages) {

    }

}
