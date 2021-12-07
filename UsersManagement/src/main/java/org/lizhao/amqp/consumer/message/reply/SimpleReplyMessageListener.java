package org.lizhao.amqp.consumer.message.reply;

import org.springframework.amqp.rabbit.listener.adapter.ReplyingMessageListener;

/**
 * simple implementation of {@link ReplyingMessageListener}
 *
 * @author lizhao
 * @version 1.0
 * @ClassName SimpleReplyMessageListener
 * @Date 2021-10-12 19:10
 * @since 1.8
 */
public class SimpleReplyMessageListener implements ReplyingMessageListener {

    @Override
    public Object handleMessage(Object o) {

        return null;
    }

}
