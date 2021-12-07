package org.lizhao.amqp.consumer.eventHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.ListenerContainerConsumerFailedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * {@link ListenerContainerConsumerFailedEvent} handler
 *
 * @author lizhao
 * @version 1.0
 * @ClassName SimpleConsumeFailuredListener
 * @Date 2021-10-13 16:01
 * @since 1.8
 */
@Component
public class SimpleConsumeFailedListener implements ApplicationListener<ListenerContainerConsumerFailedEvent> {

    private static final Logger log= LoggerFactory.getLogger(SimpleConsumeFailedListener.class);

    @Override
    public void onApplicationEvent(ListenerContainerConsumerFailedEvent event) {
        log.debug("consumer failed: container object:"+event.getSource()
                +"\r\n failure reason: "+event.getReason()
                +"\r\n retried: "+event.isFatal()
                +"\r\n throwable: "+event.getThrowable()
        );
    }

}
