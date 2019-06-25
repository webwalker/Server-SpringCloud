package com.xujian.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by xujian on 2019-06-24
 */
@SpringBootApplication
@EnableScheduling //SpringBoot默认的Scheduled定时任务、Quartz都使用
public class NormalJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(NormalJobApplication.class);
    }
}
