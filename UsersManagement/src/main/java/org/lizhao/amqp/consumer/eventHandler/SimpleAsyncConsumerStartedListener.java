package org.lizhao.amqp.consumer.eventHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.AsyncConsumerStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * {@link AsyncConsumerStartedEvent} handler
 *
 * @author lizhao
 * @version 1.0
 * @ClassName SimpleAsyncConsumerStartedListener
 * @Date 2021-10-13 16:35
 * @since 1.8
 */
@Component
public class SimpleAsyncConsumerStartedListener implements ApplicationListener<AsyncConsumerStartedEvent> {

    private static final Logger log= LoggerFactory.getLogger(SimpleAsyncConsumerStartedListener.class);

    @Override
    public void onApplicationEvent(AsyncConsumerStartedEvent event) {
        log.debug("consumer has started: "+event.toString());
    }

}
