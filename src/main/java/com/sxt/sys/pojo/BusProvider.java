package com.sxt.sys.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("bus_provider")
public class BusProvider extends Model<BusProvider> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("providername")
    private String providername;

    @TableField("zip")
    private String zip;

    @TableField("address")
    private String address;

    @TableField("telephone")
    private String telephone;

    @TableField("connectionperson")
    private String connectionperson;

    @TableField("phone")
    private String phone;

    @TableField("bank")
    private String bank;

    @TableField("account")
    private String account;

    @TableField("email")
    private String email;

    @TableField("fax")
    private String fax;

    @TableField("available")
    private Integer available;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
