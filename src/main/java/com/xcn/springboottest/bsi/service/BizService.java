package com.xcn.springboottest.bsi.service;

import com.xcn.springboottest.bsi.dao.RuleDao;
import com.xcn.springboottest.bsi.dto.RuleInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: xupeng.guo
 * @date: 2019/6/14
 * @description
 */
@Service
@Slf4j
public class BizService {

    @Autowired
    private RuleDao ruleDao;
}
