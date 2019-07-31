package com.xcn.springboottest.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.Date;

/**
 * @author: xupeng.guo
 * @date: 2019/7/16
 * @description
 */
@Component
@Slf4j
public class InitializingBeanTest implements InitializingBean {

    @PostConstruct
    public void init(){
        log.info("---------->+++++++++init");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet-------------------------------->");
    }
}
