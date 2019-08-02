package com.xcn.springboottest.bsi.service;

import com.alibaba.dubbo.common.json.ParseException;
import com.xcn.springboottest.bsi.dto.RuleInfo;

/**
 * @author: xupeng.guo
 * @date: 2019/6/14
 * @description
 */
public interface BizService {

    public String getRuleInfo();

    public RuleInfo getAllRuleInfo();

    public void tt()  throws ParseException;

    public void transactionTest() throws ParseException;

    public void transcationExcveption();
}
