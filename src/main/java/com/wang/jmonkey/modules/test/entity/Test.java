package com.wang.jmonkey.modules.test.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: test
 * @Auther: HeJiawang
 * @Date: 2018/4/12
 */
@Data
@TableName("test")
public class Test extends Model<Test> {

    @TableId
    private String id;
    private String name;
    private Date createData;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Test{" +
                    ", id=" + id +
                    ", name=" + name +
                    ", createData=" + createData +
                "}";
    }
}
