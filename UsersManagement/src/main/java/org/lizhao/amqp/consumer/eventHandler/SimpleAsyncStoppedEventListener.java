package org.lizhao.amqp.consumer.eventHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.AsyncConsumerStoppedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * {@link AsyncConsumerStoppedEvent} handler
 *
 * @author lizhao
 * @version 1.0
 * @ClassName SimpleAsyncTerminalEvent
 * @Date 2021-10-13 16:49
 * @since 1.8
 */
@Component
public class SimpleAsyncStoppedEventListener implements ApplicationListener<AsyncConsumerStoppedEvent> {

    private static final Logger log= LoggerFactory.getLogger(SimpleAsyncStoppedEventListener.class);

    @Override
    public void onApplicationEvent(AsyncConsumerStoppedEvent event) {
        log.debug("consumer has stopped: "+event.toString());
    }

}
