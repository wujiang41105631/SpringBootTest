package com.xcn.springboottest.bsi.controller;

import com.xcn.springboottest.bsi.dao.RuleDao;
import com.xcn.springboottest.bsi.dto.RuleInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author: xupeng.guo
 * @date: 2019/6/14
 * @description
 */
@RestController
@Slf4j
public class BizController {
    @Autowired
    private RuleDao ruleDao;
    @Value("${mq.producer.send}")
    private String dbUrl;

    @PostConstruct
    public void init() {
        log.error("{}", dbUrl);
    }

    @GetMapping("/getRuleInfos")
    public List<RuleInfo> getRuleInfos() {
        return ruleDao.getRuleInfos();
    }


    @RequestMapping("/")
    public String home() {
        log.info(this.getClass().getName());
        return "hello world" + this.getClass().getName();
    }
}
