package com.sxt.sys.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("sys_role_user")
public class SysRoleUser extends Model<SysRoleUser> {

    private static final long serialVersionUID = 1L;

    @TableId("rid")
    private Integer rid;

    @TableField("uid")
    private Integer uid;


    @Override
    protected Serializable pkVal() {
        return this.rid;
    }

}
