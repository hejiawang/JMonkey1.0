package com.wang.jmonkey.common.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/4/13
 */
@Data
@Accessors(chain = true)
public abstract class BaseEntity implements Serializable {

    /**
     * 创建日期
     */
    protected Date createDate;

    /**
     * 创建人
     */
    protected String createBy;

    /**
     * 最后修改日期
     */
    protected Date updateDate;

    /**
     * 最后修改人
     */
    protected String updateBy;
}
