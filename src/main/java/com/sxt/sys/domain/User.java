package com.sxt.sys.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
//import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author myq
 * @since 2020-02-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("loginname")
    private String loginname;

    @TableField("address")
    private String address;

    @TableField("sex")
    private Integer sex;

    @TableField("remark")
    private String remark;

    @TableField("pwd")
    private String pwd;

    @TableField("deptid")
    private Integer deptid;

    @TableField("hiredate")
    private Date hiredate;

    @TableField("mgr")
    private Integer mgr;

    @TableField("available")
    private Integer available;

    @TableField("ordernum")
    private Integer ordernum;

    /**
     * 用户类型[0超级管理员1，管理员，2普通用户]
     */
    @TableField("type")
    private Integer type;

    /**
     * 头像地址
     */
    @TableField("imgpath")
    private String imgpath;

    @TableField("salt")
    private String salt;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
