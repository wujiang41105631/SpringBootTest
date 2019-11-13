package com.xcn.springboottest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author: xupeng.guo
 * @date: 2019/7/12
 * @description
 */
@Configuration
@EnableScheduling
public class ScheduledConfig {

    @Bean(destroyMethod = "shutdown")
    public Executor taskScheduler() {
        return Executors.newScheduledThreadPool(20);
    }

}
