package org.lizhao.amqp.channel;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Method;
import com.rabbitmq.client.ShutdownSignalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.ShutDownChannelListener;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * count channelListener has established
 *
 * log when channel shutdown
 *
 * @author lizhao
 * @version 1.0
 * @ClassName MyChannelListener
 * @Date 2021-10-09 18:37
 * @since 1.8
 */
public class SimpleChannelListener implements ShutDownChannelListener {

    private static final Logger log= LoggerFactory.getLogger(SimpleChannelListener.class);
    private AtomicInteger count=new AtomicInteger(0);
    @Override
    public void onCreate(Channel channel, boolean transactional) {
        log.debug("rabbit channels has created counts:"+count.addAndGet(1));
    }

    @Override
    public void onShutDown(ShutdownSignalException signal) {
        Method method=signal.getReason();
        log.debug("rabbit channel shutdown because of:\n\r"
                +"rabbit protocol classID:"+method.protocolClassId()+"\r\n"
                +"rabbit protocol methodID:"+method.protocolMethodId()+"\r\n"
                +"rabbit protocol methodName:"+method.protocolMethodName()
        );
    }
}
