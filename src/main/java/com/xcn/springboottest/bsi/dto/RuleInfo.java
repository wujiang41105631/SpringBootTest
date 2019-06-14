package com.xcn.springboottest.bsi.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xupeng.guo
 */
public class RuleInfo implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 4762331752308304260L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(String ruleNo) {
        this.ruleNo = ruleNo;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    public Integer getRuleVersion() {
        return ruleVersion;
    }

    public void setRuleVersion(Integer ruleVersion) {
        this.ruleVersion = ruleVersion;
    }

    public String getRuleInput() {
        return ruleInput;
    }

    public void setRuleInput(String ruleInput) {
        this.ruleInput = ruleInput;
    }

    public String getRuleDrl() {
        return ruleDrl;
    }

    public void setRuleDrl(String ruleDrl) {
        this.ruleDrl = ruleDrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    private Integer id;

    private String ruleNo;

    private String ruleName;

    private String sceneId;

    private Integer ruleVersion;

    private String ruleInput;

    private String ruleDrl;

    private Date createTime;

    private String createUser;


}