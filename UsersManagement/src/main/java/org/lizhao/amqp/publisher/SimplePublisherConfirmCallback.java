package org.lizhao.amqp.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.concurrent.ExecutionException;

/**
 * Publisher Confirm
 *
 * First when the message sent by publisher be delivered to the queue with the routingKey,the Exchange will return an acknowledgement;
 * Second when the message stored in queue be received by a consumer,the consumer will return an acknowledgement.
 *
 * @author lizhao
 * @version 1.0
 * @ClassName MyConfirmCallback
 * @Date 2021-10-09 19:37
 * @since 1.8
 */
public class SimplePublisherConfirmCallback implements RabbitTemplate.ConfirmCallback {

    private static final Logger log= LoggerFactory.getLogger(SimplePublisherConfirmCallback.class);

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {

        try {
            if(ack){//
                log.debug("消息发送失败： "+(correlationData==null?null:correlationData.getFuture().get().getReason()));
            }else{
                log.debug("消息发送失败： "+(correlationData==null?null:correlationData.getFuture().get().getReason()+"\r\n"+cause));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
