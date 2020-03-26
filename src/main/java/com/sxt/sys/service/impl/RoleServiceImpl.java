//package com.sxt.sys.service.impl;
//
//import com.sxt.sys.domain.Role;
//import com.sxt.sys.mapper.RoleMapper;
//import com.sxt.sys.service.RoleService;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import java.io.Serializable;
//
///**
// * <p>
// *  服务实现类
// * </p>
// *
// * @author myq
// * @since 2020-02-28
// */
//@Service
//@Transactional
//public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
//
//    @Override
//    public boolean removeById(Serializable id) {
//        //根据角色ID删除sys_role_permission
//        this.getBaseMapper().deleteRolePermissionByRid(id);
//        //根据角色ID删除sys_role_user
//        this.getBaseMapper().deleteRoleUserByRid(id);
//        return super.removeById(id);
//    }
//
//}


package com.sxt.sys.service.impl;

import com.sxt.sys.domain.Role;
import com.sxt.sys.mapper.RoleMapper;
import com.sxt.sys.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 老雷
 * @since 2019-09-24
 */
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    public boolean removeById(Serializable id) {
        //  根据角色ID删除sys_role_permission
        this.getBaseMapper().deleteRolePermissionByRid(id);
        //根据角色ID删除sys_role_user
        this.getBaseMapper().deleteRoleUserByRid(id);
        return super.removeById(id);
    }


    //    @Override
//    public boolean removeById(Serializable id) {
//        //根据角色ID删除sys_role_permission
//        this.getBaseMapper().deleteRolePermissionByRid(id);
//        //根据角色ID删除sys_role_user
//        this.getBaseMapper().deleteRoleUserByRid(id);
//        return super.removeById(id);
//    }


}
