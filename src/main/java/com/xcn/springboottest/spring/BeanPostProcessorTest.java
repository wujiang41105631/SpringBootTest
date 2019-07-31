package com.xcn.springboottest.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author: xupeng.guo
 * @date: 2019/7/16
 * @description
 */
@Slf4j
@Component
public class BeanPostProcessorTest implements BeanPostProcessor{

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equalsIgnoreCase("InitializingBeanTest")){
            log.info("BeanPostProcessorTest ----------------------> " + beanName);
        }
        return bean;
    }


    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equalsIgnoreCase("InitializingBeanTest")){
            log.info("postProcessAfterInitialization ----------------------> " + beanName);
        }
        return bean;
    }
}
