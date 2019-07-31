package com.xcn.springboottest.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @author: xupeng.guo
 * @date: 2019/7/22
 * @description
 */
@Service
@Slf4j
public class ApplicationListenerTest implements ApplicationListener{

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("ApplicationListenerTest----" + event.toString());
    }
}
