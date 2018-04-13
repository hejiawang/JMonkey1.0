package com.wang.jmonkey.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.wang.jmonkey.common.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @Auther: HeJiawang
 * @Date: 2018/4/13
 */
@Data
@Accessors(chain = true)
@TableName("sys_user")
public class UserEntity extends BaseEntity {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 用户登录名
     */
    private String userName;

    /**
     * 屏幕显示名
     */
    private String realName;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

}
