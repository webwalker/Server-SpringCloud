package com.xujian.apollo.bean;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigFile;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.core.enums.ConfigFileFormat;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 使用@ApolloConfig自动注入Config对象
 * 使用@ApolloConfigChangeListener自动注入ConfigChangeListener对象
 * 当监听到属性值发生变化后使用Config API修改属性值
 */
@Configuration
@Slf4j
public class TestApolloAnnotationBean {
    @ApolloConfig
    private Config config; //inject config for default namespace application
    @ApolloConfig("application")
    private Config anotherConfig; //inject config for namespace application
    @ApolloConfig("TEST1.apollo")
    private Config yetAnotherConfig; //inject config for namespace FX.apollo
    @ApolloConfig("application.yml")
    private Config ymlConfig; //inject config for namespace application.yml

    /**
     * ApolloJsonValue annotated on fields example, the default value is specified as empty list - []
     * <br />
     * jsonBeanProperty=[{"someString":"hello","someInt":100},{"someString":"world!","someInt":200}]
     */
    @ApolloJsonValue("${jsonBeanProperty:[]}")
    private List<JsonBean> anotherJsonBeans;

    @Value("${batch:100}")
    private int batch;

    //config change listener for namespace application
    @ApolloConfigChangeListener
    private void someOnChange(ConfigChangeEvent changeEvent) {
        System.out.println("---->someOnChange changed.");
        //update injected value of batch if it is changed in Apollo
        if (changeEvent.isChanged("batch")) {
            batch = config.getIntProperty("batch", 100);
        }

        for (String key : changeEvent.changedKeys()) {
            ConfigChange change = changeEvent.getChange(key);
            log.info("Change - key: {}, oldValue: {}, newValue: {}, changeType: {}",
                    change.getPropertyName(), change.getOldValue(), change.getNewValue(),
                    change.getChangeType());
        }
    }

    //config change listener for namespace application
    @ApolloConfigChangeListener("application")
    private void anotherOnChange(ConfigChangeEvent changeEvent) {
        //do something
        System.out.println("---->anotherOnChange changed.");
    }

    //config change listener for namespaces application, TEST1.apollo and application.yml
    @ApolloConfigChangeListener({"application", "TEST1.apollo", "application.yml"})
    private void yetAnotherOnChange(ConfigChangeEvent changeEvent) {
        //do something
        System.out.println("---->yetAnotherOnChange changed.");
        for (String key : changeEvent.changedKeys()) {
            ConfigChange change = changeEvent.getChange(key);
            log.info("Change - key: {}, oldValue: {}, newValue: {}, changeType: {}",
                    change.getPropertyName(), change.getOldValue(), change.getNewValue(),
                    change.getChangeType());
        }
    }

    //example of getting config from Apollo directly
    //this will always return the latest value of timeout
    public int getTimeout() {
        return config.getIntProperty("timeout", 200);
    }

    //example of getting config from injected value
    //the program needs to update the injected value when batch is changed in Apollo using @ApolloConfigChangeListener shown above
    public int getBatch() {
        return this.batch;
    }

    private static class JsonBean {
        private String someString;
        private int someInt;
    }

    //sdk功能获取自定义配置
    private void getConfig() {
        Config config = ConfigService.getConfig("application.yml");
        String someNamespace = "test";

        ConfigFile configFile = ConfigService.getConfigFile("test", ConfigFileFormat.XML);
        String content = configFile.getContent();
    }
}
