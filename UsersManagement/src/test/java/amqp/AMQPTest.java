package amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * //Description TODO
 *
 * @author lizhao
 * @version 1.0
 * @ClassName Test
 * @Date 2021-10-19 18:28
 * @since 1.8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-mq.xml")
public class AMQPTest {

    private static final Logger logger= LoggerFactory.getLogger(AMQPTest.class);
    @Autowired
    AmqpTemplate template;

    @Test
    public void test(){

        Message mes=new Message("rabbitMQ第一次发送测试".getBytes());
        template.send("exchange","loginS",mes);
        System.out.println("数据以发送");
    }

}
