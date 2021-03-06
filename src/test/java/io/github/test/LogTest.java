package io.github.test;

import io.github.base.BaseAppTest;
import io.github.util.log.LogUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.boot.logging.LogFile;
import org.springframework.boot.logging.LoggingInitializationContext;

/**
 * 日志测试类
 *
 * @author Created by 思伟 on 2020/3/17
 */
public class LogTest extends BaseAppTest {

    /**
     * TODO logback.xml 是如何加载的？
     * ch.qos.logback.ext.spring.web.LogbackConfigListener
     * 改回默认logback即可正常在main方法使用,-spring是通过SpringBoot来自动装配的
     *
     * @see org.springframework.boot.logging.logback.LogbackLoggingSystem#loadConfiguration(LoggingInitializationContext, String, LogFile)
     */
    public static void main(String[] args) {
        System.setProperty("logback.configurationFile", "classpath:/logback-spring.xml");
        // 输出文件
        Logger logger = LogUtil.getInstance().getFileStatementLogger();
        logger.debug("debug file Statement");
        logger.warn("warn file Statement");
        logger.error("error file Statement");
    }

    /**
     * 输出文件
     */
    @Test
    public void testLogForFile() {
        Logger logger = LogUtil.getInstance().getFileStatementLogger();
        logger.debug("debug file Statement");
        logger.warn("warn file Statement");
        logger.error("error file Statement");
    }

}
