package org.lizhao.amqp.consumer.container;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.ListenerContainerIdleEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * detect which listener container has reach idle limit time
 *
 * idleEventInterval set in ListenerContainerFactory
 *
 *
 *
 * @author lizhao
 * @version 1.0
 * @ClassName SimpleContainerIdleListener
 * @Date 2021-10-13 15:14
 * @since 1.8
 */
@Component
public class SimpleContainerIdleListener implements ApplicationListener<ListenerContainerIdleEvent> {

    private static final Logger log= LoggerFactory.getLogger(SimpleContainerIdleListener.class);

    @Override
    public void onApplicationEvent(ListenerContainerIdleEvent event) {
        log.debug("amqp listener container with id/name: "+event.getListenerId()+" has be idle "+event.getIdleTime()+" milliseconds"
                +"\r\n queues listened by this container is "+event.getQueueNames().toString()
                +"\r\n container instance: "+event.getSource()
        );
    }

}