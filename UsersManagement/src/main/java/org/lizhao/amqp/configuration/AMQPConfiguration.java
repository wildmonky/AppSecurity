package org.lizhao.amqp.configuration;

import org.lizhao.amqp.channel.SimpleChannelListener;
import org.lizhao.amqp.consumer.message.SimpleMessageListener;
import org.lizhao.amqp.consumer.message.SimpleMessageListenerAdapterDelegate;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.*;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * configure two queues to store message about state of login
 *
 * only queue,exchange,binding define as beans can be used with spring amqp recovery
 *
 * @author lizhao
 * @version 1.0
 * @ClassName AMQPConfiguration
 * @Date 2021-10-07 19:12
 * @since 1.8
 */
@Configuration
public class AMQPConfiguration {

    @Autowired
    public AMQPConfiguration(@Qualifier("rabbitConnectionFactory") CachingConnectionFactory factory){
        factory.addChannelListener(new SimpleChannelListener());
    }
//    @PostConstruct
//    public void Configuration(@Qualifier("rabbitConnectionFactory") CachingConnectionFactory factory){
//        factory.addChannelListener(new SimpleChannelListener());
//    }

    @Bean
    public Queue loginSuccessQueue(){
        return new Queue("loginSuccess");
    }

    @Bean
    public Queue loginFailureQueue(){
        return new Queue("loginFailure");
    }

    @Bean
    public Exchange exchange(){
        return new TopicExchange("exchange");
    }

    @Bean
    public Binding loginSuccessBinding(){
        return BindingBuilder.bind(loginSuccessQueue()).to(exchange()).with("loginS").noargs();
    }

    @Bean
    public Binding loginFailureBinding(){
        return BindingBuilder.bind(loginFailureQueue()).to(exchange()).with("loginF").noargs();
    }

    @Bean
    public MessageListenerContainer messageListenerContainer(@Qualifier("rabbitConnectionFactory") CachingConnectionFactory factory){
        SimpleMessageListenerContainer listenerContainer=new SimpleMessageListenerContainer(factory);

        //message adapter listener
        MessageListenerAdapter messageListenerAdapter=new MessageListenerAdapter(new SimpleMessageListenerAdapterDelegate());
        messageListenerAdapter.setDefaultListenerMethod("handleMessage");

        listenerContainer.addQueueNames(new String[]{"loginSuccess"});
        listenerContainer.setMessageListener(new SimpleMessageListener());

        return listenerContainer;
    }
    
}