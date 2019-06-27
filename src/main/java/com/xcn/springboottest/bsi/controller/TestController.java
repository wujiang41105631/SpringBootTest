package com.xcn.springboottest.bsi.controller;

import com.test.service.DemoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xupeng.guo
 * @date: 2019/6/17
 * @description
 */
@RestController
public class TestController {


    @RequestMapping("/home")
    public String home() {
        return "hello world" + this.getClass().getName() + ":" + demoInterface.getDemoBean().toString();
    }

    @Autowired
    private DemoInterface demoInterface;
}
