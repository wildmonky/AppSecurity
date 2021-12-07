package org.lizhao.amqp.consumer.message;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

import java.util.List;

/**
 * simple implementation of {@link ChannelAwareMessageListener}
 *
 *
 * @author lizhao
 * @version 1.0
 * @ClassName SimpleChannelAwareMessageListener
 * @Date 2021-10-12 18:41
 * @since 1.8
 */
public class SimpleChannelAwareMessageListener implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {



    }

    @Override
    public void onMessageBatch(List<Message> messages, Channel channel) {

    }

    @Override
    public void containerAckMode(AcknowledgeMode mode) {
        // NOSONAR - empty
    }

}
