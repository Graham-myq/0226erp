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
@TableName("bus_goods")
public class BusGoods extends Model<BusGoods> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("goodsname")
    private String goodsname;

    @TableField("produceplace")
    private String produceplace;

    @TableField("size")
    private String size;

    @TableField("goodspackage")
    private String goodspackage;

    @TableField("productcode")
    private String productcode;

    @TableField("promitcode")
    private String promitcode;

    @TableField("description")
    private String description;

    @TableField("price")
    private Double price;

    @TableField("number")
    private Integer number;

    @TableField("dangernum")
    private Integer dangernum;

    @TableField("goodsimg")
    private String goodsimg;

    @TableField("available")
    private Integer available;

    @TableField("providerid")
    private Integer providerid;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
