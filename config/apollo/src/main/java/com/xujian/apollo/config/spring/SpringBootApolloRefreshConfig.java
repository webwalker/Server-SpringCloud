package com.xujian.apollo.config.spring;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.stereotype.Component;

@ConditionalOnProperty("redis.cache.enabled")
@Component
public class SpringBootApolloRefreshConfig {
    private static final Logger logger = LoggerFactory.getLogger(SpringBootApolloRefreshConfig.class);

    private final SampleRedisConfig sampleRedisConfig;
    private final RefreshScope refreshScope;

    public SpringBootApolloRefreshConfig(
            final SampleRedisConfig sampleRedisConfig,
            final RefreshScope refreshScope) {
        this.sampleRedisConfig = sampleRedisConfig;
        this.refreshScope = refreshScope;
    }

//    @ApolloConfigChangeListener(value = {ConfigConsts.NAMESPACE_APPLICATION, "TEST1.apollo", "application.yml"},
//            interestedKeyPrefixes = {"redis.cache."}) //只对自己感兴趣的可以监听(前缀规则)
    public void onChange(ConfigChangeEvent changeEvent) {
        System.out.println("======================>ApolloConfigChangeListener");
        logger.info("before refresh {}", sampleRedisConfig.toString());
        refreshScope.refresh("sampleRedisConfig");
        logger.info("after refresh {}", sampleRedisConfig.toString());
    }
}
