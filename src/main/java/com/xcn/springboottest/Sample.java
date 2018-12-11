package com.xcn.springboottest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintStream;

@RestController
//@ComponentScan(value="com.xcn.springboottest")
//@EnableAutoConfiguration
@SpringBootApplication
public class Sample {
    private Logger logger = LoggerFactory.getLogger(Sample.class);

    @RequestMapping("/")
    public String home() {
        logger.info(this.getClass().getName());
        return "hello world";
    }


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Sample.class);
        Banner banner = new Banner() {
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {

            }
        };
//		app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
