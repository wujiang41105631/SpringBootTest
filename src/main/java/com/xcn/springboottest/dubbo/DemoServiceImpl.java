package com.xcn.springboottest.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.test.dto.DemoBean;
import com.test.service.DemoInterface;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author: xupeng.guo
 * @date: 2019/6/17
 * @description
 */
@Service
public class DemoServiceImpl implements DemoInterface {

    @Value("${mq.producer.send}")
    private String providerGroup;


    @Override
    public DemoBean getDemoBean() {
        DemoBean b = new DemoBean();
        b.setName("zhangsan");
        b.setCardNo("111111111111111111111111111");
        return b;
    }
}
