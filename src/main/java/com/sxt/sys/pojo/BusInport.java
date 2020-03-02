package com.sxt.sys.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("bus_inport")
public class BusInport extends Model<BusInport> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("paytype")
    private String paytype;

    @TableField("inporttime")
    private LocalDateTime inporttime;

    @TableField("operateperson")
    private String operateperson;

    @TableField("number")
    private Integer number;

    @TableField("remark")
    private String remark;

    @TableField("inportprice")
    private Double inportprice;

    @TableField("providerid")
    private Integer providerid;

    @TableField("goodsid")
    private Integer goodsid;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
