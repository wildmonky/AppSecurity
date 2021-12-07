package org.lizhao.amqp.consumer.message;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;

/**
 * simple implementation of delegate within {@link org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter}
 *
 * @author lizhao
 * @version 1.0
 * @ClassName SimpleMessageListenerAdapterDelegate
 * @Date 2021-10-12 18:15
 * @since 1.8
 */
public class SimpleMessageListenerAdapterDelegate {

    private static final Logger log= LoggerFactory.getLogger(SimpleMessageListenerAdapterDelegate.class);

    /**
     * //description
     *
     * @author lizhao
     * @Date 2021/10/12 19:31
     * @MethodName handleMessage
     * @param extractedMessage:
     * @param message:
     * @param channel:
     * @return void
     */
    public void handleMessage(Object extractedMessage, Message message,Channel channel){
        log.debug("can not find appropriate method to handle this message:\r\n"
                +"from queue:"+message.getMessageProperties().getConsumerQueue()
                +"\r\n message body:"+message.getBody().toString()
        );
    }

    /**
     * //description
     *
     * @author lizhao
     * @Date 2021/10/12 19:31
     * @MethodName login
     * * @param extractedMessage:
     * @param message:
     * @param channel:
     * @return void
     */
    public void login(Object extractedMessage, Message message,Channel channel){




    }


}
