package com.xcn.springboottest;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Hello world!
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.xcn.springboottest"})
@EnableScheduling
@PropertySource("classpath:mq-config.properties")
@EnableAsync
@EnableAspectJAutoProxy(proxyTargetClass=true, exposeProxy=true)//开启AOP,//proxyTargetClass=true 强制使用AOP代理,exposeProxy=true
@EnableTransactionManagement
public class App {
    public static void main(String[] args) {
//        SpringApplication.run(new Class[]{App.class}, args);
        SpringApplication sa = new SpringApplication(App.class);
        sa.setBannerMode(Banner.Mode.OFF);
        sa.run(args);
    }

}
//
///**
// * 项目通过tomcat启动的话 操作如下
// */
//public class App extends SpringBootServletInitializer {
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        //DevourerServiceStarter.class为带有@SpringBootApplication注解的启动类
//        return builder.sources(App.class);
//    }
//}
