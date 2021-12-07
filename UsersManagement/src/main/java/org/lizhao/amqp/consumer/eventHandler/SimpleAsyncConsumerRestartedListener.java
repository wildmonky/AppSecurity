package org.lizhao.amqp.consumer.eventHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.AsyncConsumerRestartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * {@link AsyncConsumerRestartedEvent} handler
 *
 * @author lizhao
 * @version 1.0
 * @ClassName SimpleAsyncConsumerRestartedListener
 * @Date 2021-10-13 16:44
 * @since 1.8
 */
@Component
public class SimpleAsyncConsumerRestartedListener implements ApplicationListener<AsyncConsumerRestartedEvent> {

    private static final Logger log= LoggerFactory.getLogger(SimpleAsyncConsumerRestartedListener.class);

    @Override
    public void onApplicationEvent(AsyncConsumerRestartedEvent event) {
        log.debug("consumer has restarted: "+event.toString());
    }
}
