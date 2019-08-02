package com.xcn.springboottest.bsi.dao;

import com.xcn.springboottest.bsi.dto.CreditResultMetaInfo;
import com.xcn.springboottest.bsi.dto.RuleInfo;

import java.util.List;


/**
 * @author xupeng.guo
 */
public interface RuleDao {

//    @Select("select * from rule_entity limit 0,10")
//    @Results(id = "ruleEntity", value = {
//            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT),
//            @Result(column = "rule_no", property = "ruleNo", jdbcType = JdbcType.VARCHAR),
//            @Result(column = "scene_id", property = "sceneId", jdbcType = JdbcType.VARCHAR),
//            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
//    })
//    List<RuleInfo> getRuleInfos();

    List<RuleInfo> getRuleInfos();

    void transacationInsert(CreditResultMetaInfo creditResultMetaInfo);
}
