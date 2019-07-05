package com.xujian.rocketmq.config;

import org.apache.rocketmq.spring.annotation.ExtRocketMQTemplateConfiguration;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

/**
 * 非标自定义, template里面的所有属性都可以自定义
 * Created by xujian on 2019-07-01
 */
@ExtRocketMQTemplateConfiguration(nameServer = "${demo.rocketmq.extNameServer}",
        group = RocketMQConfig.TOPIC_GROUP2)
public class ExtRocketMQTemplate extends RocketMQTemplate {
    //类里面不需要做任何修改
}