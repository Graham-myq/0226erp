package com.sxt.sys.mapper;

import com.sxt.sys.domain.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;

import java.io.Serializable;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author myq
 * @since 2020-02-28
 */
public interface RoleMapper extends BaseMapper<Role> {
    //根据角色ID删除sys_role_permission
    @Delete("delete from sys_role_permission where rid=#{value}")
    void deleteRolePermissionByRid(Serializable id);
    //根据角色ID删除sys_role_user
    @Delete("delete from sys_role_user where rid=#{value}")
    void deleteRoleUserByRid(Serializable id);

}
