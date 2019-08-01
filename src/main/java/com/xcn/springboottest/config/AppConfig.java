package com.xcn.springboottest.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xupeng.guo
 * @date: 2019/8/1
 * @description
 */
@Configuration
@ConfigurationProperties(prefix = "app.config")
@Data
public class AppConfig {

    public String appName;
    public String appDesc;
    public int appPort;
}
