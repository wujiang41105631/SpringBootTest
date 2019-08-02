package com.xcn.springboottest.bsi.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author: xupeng.guo
 * @date: 2019/8/2
 * @description
 */
@Data
public class CreditResultMetaInfo {

    private static final long serialVersionUID = 7075262848650646010L;
    private Long id;
    private Long assetId;
    private String batchId;
    private String supplierName;
    private String interfaceName;
    private Integer creditStatus;
    private Date createTime;
    private Date updateTime;
    private String testFlag;
    private String sceneId;
    private Integer creditStep;
    private Integer assetResultVersion;
    private String creditModelUnikey;
}
