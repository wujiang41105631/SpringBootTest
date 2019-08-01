package com.xcn.springboottest.bsi.service;

import com.alibaba.dubbo.common.json.JSON;
import com.xcn.springboottest.bsi.dao.RuleDao;
import com.xcn.springboottest.bsi.dto.RuleInfo;
import com.xcn.springboottest.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author: xupeng.guo
 * @date: 2019/6/14
 * @description
 */
@Service
@Slf4j
public class BizSerivceImpl implements BizService {

    @Autowired
    private RuleDao ruleDao;
    @Autowired
    private AppConfig appConfig;

    @PostConstruct
    public void init(){
        log.info("------------------------> biz init");
        log.info("---->" + appConfig.getAppDesc());
    }

    @Override
    public String getRuleInfo() {
        try {
            return JSON.json(ruleDao.getRuleInfos().get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public RuleInfo getAllRuleInfo() {
        return ruleDao.getRuleInfos().get(0);
    }
}
