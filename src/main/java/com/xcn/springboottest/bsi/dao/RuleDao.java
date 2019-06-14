package com.xcn.springboottest.bsi.dao;

import com.xcn.springboottest.bsi.dto.RuleInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

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
}
