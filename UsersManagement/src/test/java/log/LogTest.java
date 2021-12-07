package log;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.FilterChainProxy;

import java.io.IOException;

/**
 * //Description TODO
 *
 * @author lizhao
 * @version 1.0
 * @ClassName log.LogTest
 * @Date 2021-10-20 18:32
 * @since 1.8
 */
public class LogTest {

    private static final Logger logger= LoggerFactory.getLogger(LogTest.class);

    @Test
    public void test() throws IOException {
        //System.out.println(this.getClass().getClassLoader().getResource("log4j2.properties"));
        logger.trace("日志测试1");
        logger.debug("日志测试2");
        logger.info("日志测试3");
        logger.warn("日志测试4");
        logger.error("日志测试5");

    }

}
