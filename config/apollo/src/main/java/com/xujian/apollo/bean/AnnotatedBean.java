package com.xujian.apollo.bean;

import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Java Config方式
 * 不需要写set方法，直接在属性字段上增加即可
 */
//@Component("annotatedBean")
@Configuration
public class AnnotatedBean {
    private static final Logger logger = LoggerFactory.getLogger(AnnotatedBean.class);

    private int timeout;
    private int batch;
    private List<JsonBean> jsonBeans;
    //用于测试order优先级, 默认的没有testKey配置，后面的有
    private int test;

    @Value("${testKey:100}")
    private void myTest(int test) {
        logger.info("updating test, old value: {}, new value: {}", this.test, test);
        this.test = test;
    }

    /**
     * ApolloJsonValue annotated on fields example, the default value is specified as empty list - []
     * <br />
     * jsonBeanProperty=[{"someString":"hello","someInt":100},{"someString":"world!","someInt":200}]
     */
    @ApolloJsonValue("${jsonBeanProperty:[]}")
    private List<JsonBean> anotherJsonBeans;

    @Value("${batch:100}")
    public void setBatch(int batch) {
        logger.info("updating batch, old value: {}, new value: {}", this.batch, batch);
        this.batch = batch;
    }

    @Value("${timeout:200}")
    public void setTimeout(int timeout) {
        logger.info("updating timeout, old value: {}, new value: {}", this.timeout, timeout);
        this.timeout = timeout;
    }

    public int getTimeout() {
        return timeout;
    }

    /**
     * ApolloJsonValue annotated on methods example, the default value is specified as empty list - []
     * <br />
     * jsonBeanProperty=[{"someString":"hello","someInt":100},{"someString":"world!","someInt":200}]
     */
    @ApolloJsonValue("${jsonBeanProperty:[]}")
    public void setJsonBeans(List<JsonBean> jsonBeans) {
        logger.info("updating json beans, old value: {}, new value: {}", this.jsonBeans, jsonBeans);
        this.jsonBeans = jsonBeans;
    }

    @Override
    public String toString() {
        return String.format("[AnnotatedBean] timeout: %d, batch: %d, jsonBeans: %s", timeout, batch, jsonBeans);
    }

    private static class JsonBean {
        private String someString;
        private int someInt;

        @Override
        public String toString() {
            return "JsonBean{" +
                    "someString='" + someString + '\'' +
                    ", someInt=" + someInt +
                    '}';
        }
    }
}
