package org.lizhao.amqp.service;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * //Description TODO
 *
 * @author lizhao
 * @version 1.0
 * @ClassName RabbitMQService
 * @Date 2021-10-07 16:41
 * @since 1.8
 */
@Service
public class RabbitMQService implements InitializingBean {

    AmqpTemplate rabbitTemplate;
    AmqpAdmin rabbitAdmin;

    @Autowired
    public RabbitMQService(AmqpTemplate rabbitTemplate,AmqpAdmin rabbitAdmin) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitAdmin=rabbitAdmin;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

//        Exchange exchange=new TopicExchange("hh");
//        Queue queue=new Queue("hh");
//        rabbitAdmin.declareExchange(exchange);
//        rabbitAdmin.declareQueue(queue);
//        Binding binding=BindingBuilder.bind(queue).to(exchange).with("xse").noargs();
//        rabbitAdmin.declareBinding(binding);
//        rabbitAdmin.initialize();
    }



    public String getMessage(){
        return "";
    }


}
