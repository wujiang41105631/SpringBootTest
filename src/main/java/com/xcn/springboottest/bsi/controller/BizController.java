package com.xcn.springboottest.bsi.controller;

import com.xcn.springboottest.bsi.dto.RuleInfo;
import com.xcn.springboottest.bsi.service.BizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: xupeng.guo
 * @date: 2019/6/14
 * @description
 */
@RestController
@RequestMapping
@Slf4j
public class BizController {
    @Autowired
    private BizService bizService;
    @Value("${mq.producer.send}")
    private String mqTopic;

    /**
     * 字段注入
     */
    @PostConstruct
    public void init() {
        log.error("{}", mqTopic);
    }

    /**
     * 查库
     *
     * @return
     */
    @GetMapping("/getRuleInfos")
    public List<RuleInfo> getRuleInfos() {
        List<RuleInfo> objects = new ArrayList<>();
        objects.add(bizService.getAllRuleInfo());
        return objects;
    }


    @RequestMapping("/home")
    public String home() {
        log.info(this.getClass().getName());
        return "hello world" + this.getClass().getName();
    }

    /**
     * 异常处理
     *
     * @return
     */
    @RequestMapping("/exception")
    public String exception() {
        throw new NullPointerException("test");
    }
}
