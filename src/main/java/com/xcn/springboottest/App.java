package com.xcn.springboottest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
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
//public class App {
//    public static void main(String[] args) {
//        SpringApplication.run(new Class[]{App.class}, args);
//    }
//
//}

/**
 * 项目通过tomcat启动的话 操作如下
 */
public class App extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //DevourerServiceStarter.class为带有@SpringBootApplication注解的启动类
        return builder.sources(App.class);
    }
}
