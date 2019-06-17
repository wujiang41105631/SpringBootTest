package com.xcn.springboottest.bsi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xupeng.guo
 * @date: 2019/6/17
 * @description
 */
@RestController("test")
public class TestController {


    @RequestMapping("/home")
    public String home() {
        return "hello world" + this.getClass().getName();
    }
}
