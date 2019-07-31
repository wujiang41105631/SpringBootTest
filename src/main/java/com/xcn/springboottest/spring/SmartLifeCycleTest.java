package com.xcn.springboottest.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * @author: xupeng.guo
 * @date: 2019/7/31
 * @descon
 */
@Component
@Slf4j
public class SmartLifeCycleTest implements SmartLifecycle {
    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {

    }

    @Override
    public void start() {
        log.info("-----------> SmartLifeCycleTest");
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public int getPhase() {
        return 0;
    }
}
