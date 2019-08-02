package com.xcn.springboottest.bsi.service;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.ParseException;
import com.xcn.springboottest.bsi.dao.RuleDao;
import com.xcn.springboottest.bsi.dto.CreditResultMetaInfo;
import com.xcn.springboottest.bsi.dto.RuleInfo;
import com.xcn.springboottest.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void init() throws ParseException {
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

    /**
     * 1. 加了Transactional的方法,在同类之间调用是不会有事务的。比如在本类的init方法中调用本方法事务不会生效
     * 2. 在其他类中调用此方法，事务会生效,需要使用
     * 针对问题1 需要使用 AopContext.currentProxy()来操作,此时需pom中引入spring-boot-starter-aop，且引入@EnableAspectJAutoProxy(proxyTargetClass=true, exposeProxy=true)
     *
     * @throws ParseException
     */
    @Override
    public void tt() throws ParseException {
        ((BizService) AopContext.currentProxy()).transactionTest(); // 这种调用方式事务回滚了
//        transactionTest(); //这种调用方式 事务不会滚
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void transactionTest() throws ParseException {
        String jsonStr = "{\n" +
                "    \"assetId\": 902181,\n" +
                "    \"assetResultVersion\": 15,\n" +
                "    \"batchId\": \"2d96b59c14f0488588eb1ef7f4d09b5e\",\n" +
                "    \"creditModelUnikey\": \"210002100006\",\n" +
                "    \"creditStatus\": 1,\n" +
                "    \"creditStep\": 2,\n" +
                "    \"id\": 5558,\n" +
                "    \"interfaceName\": \"fwAppCreditNoneModelV2S1\",\n" +
                "    \"sceneId\": \"10002\",\n" +
                "    \"supplierName\": \"model\",\n" +
                "}";
        CreditResultMetaInfo parse = JSON.parse(jsonStr, CreditResultMetaInfo.class);
        ruleDao.transacationInsert(parse);
        log.info("------->");
        transcationExcveption();
    }

    private void transcationExcveption() {
        log.info("will throw exception");
        throw new RuntimeException("yichang");
    }
}
