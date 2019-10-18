package com.xcn.springboottest.bsi.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xupeng.guo
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonPropertyOrder(value = {"",""}) // json序列化后,字段顺序
public class RuleInfo implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 4762331752308304260L;

    // 不做序列化
    @JsonIgnore
    private Integer id;

    @JsonProperty("xxxx") // 起别名
    private String ruleNo;

    private String ruleName;

    private String sceneId;

    private Integer ruleVersion;

    private String ruleInput;

    private String ruleDrl;

    @JsonInclude(JsonInclude.Include.NON_NULL) // 只有不为空才会去序列化这个东西.
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") //时间格式化,可以在application.properties 重甲
    private Date createTime;

    private String createUser;


}