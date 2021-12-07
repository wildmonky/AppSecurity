package org.lizhao.amqp.consumer.eventHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.ConsumeOkEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * {@link ConsumeOkEvent} handler
 *
 * triggered when the ConsumeOkEvent emitted by the listener container which indicate the queue has described by consumer
 *
 * @author lizhao
 * @version 1.0
 * @ClassName SimpleConsumerOkEventListener
 * @Date 2021-10-13 16:53
 * @since 1.8
 */
@Component
public class SimpleConsumerOkEventListener implements ApplicationListener<ConsumeOkEvent> {

    private static final Logger log= LoggerFactory.getLogger(SimpleConsumerOkEventListener.class);

    @Override
    public void onApplicationEvent(ConsumeOkEvent event) {
        log.debug("the queue with name \""+event.getQueue()+"\" has described by the consumer "+event.getSource()+" with tags "+event.getConsumerTag());
    }
}