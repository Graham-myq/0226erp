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
@TableName("bus_outport")
public class BusOutport extends Model<BusOutport> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("providerid")
    private Integer providerid;

    @TableField("paytype")
    private String paytype;

    @TableField("outputtime")
    private LocalDateTime outputtime;

    @TableField("operateperson")
    private String operateperson;

    @TableField("outportprice")
    private Double outportprice;

    @TableField("number")
    private Integer number;

    @TableField("remark")
    private String remark;

    @TableField("goodsid")
    private Integer goodsid;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
