package com.xcn.springboottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.xcn.springboottest"})
@EnableScheduling
@PropertySource("classpath:mq-config.properties")
@EnableAsync
//@EnableDubboConfiguration
public class App {
    public static void main(String[] args) {
        SpringApplication.run(new Class[]{App.class}, args);
    }

}
