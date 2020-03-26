package com.sxt.sys.vo;

import com.sxt.sys.domain.Notice;
import com.sxt.sys.domain.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class RoleVo extends Role {

    private static final long serialVersionUID = 1L;

    private Integer page = 1;
    private Integer limit = 10;



}
