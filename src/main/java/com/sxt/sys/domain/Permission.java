package com.sxt.sys.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author myq
 * @since 2020-02-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("pid")
    private Integer pid;

    /**
     * 权限类型[menu/permission]
     */
    @TableField("type")
    private String type;

    @TableField("title")
    private String title;

    /**
     * 权限编码[只有type= permission才有  user:view]
     */
    @TableField("percode")
    private String percode;

    @TableField("icon")
    private String icon;

    @TableField("href")
    private String href;

    @TableField("target")
    private String target;

    @TableField("open")
    private Integer open;

    @TableField("ordernum")
    private Integer ordernum;

    /**
     * 状态【0不可用1可用】
     */
    @TableField("available")
    private Integer available;



    protected Serializable pkVal() {
        return this.id;
    }

}
