package com.sxt.sys.cache;

import com.sxt.sys.domain.Dept;
import com.sxt.sys.vo.DeptVo;
import org.apache.commons.logging.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@EnableAspectJAutoProxy
public class CacheAspect {

    /**
     * 日志出处
     */
    private Log log = LogFactory.getLog(CacheAspect.class);

    //声明一个缓存容器
    private Map<String, Object> CACHE_CONTAINER = new HashMap<>();

    //声明访问表达式
    private static final String POINCUT_DEPT_ADD = "execution(* com.sxt.sys.service.impl.DeptServiceImpl.save(..))";
    private static final String POINCUT_DEPT_UPDATE = "execution(* com.sxt.sys.service.impl.DeptServiceImpl.updateById(..))";
    private static final String POINCUT_DEPT_GET = "execution(* com.sxt.sys.service.impl.DeptServiceImpl.getById(..))";
    private static final String POINCUT_DEPT_DELETE = "execution(* com.sxt.sys.service.impl.DeptServiceImpl.removeById(..))";

    private static final String CACHE_DEPT_PROFIX = "dept:";


    /**
     * 部门添加切入
     */
    @Around(value = POINCUT_DEPT_ADD)
    public Object cacheDeptAdd(ProceedingJoinPoint joinPoint) throws Throwable {
        //取出第一个参数
        Dept object = (Dept) joinPoint.getArgs()[0];
        Boolean res = (Boolean) joinPoint.proceed();
        if (res) {
            CACHE_CONTAINER.put(CACHE_DEPT_PROFIX + object.getId(), object);
        }
        return res;
    }

    /**
     * 查询切入
     */
    @Around(value = POINCUT_DEPT_GET)
    public Object cacheDeptGet(ProceedingJoinPoint joinPoint) throws Throwable {
        //取出第一个参数
        Integer object = (Integer) joinPoint.getArgs()[0];
        //从缓存里面取
        Object res1 = CACHE_CONTAINER.get(CACHE_DEPT_PROFIX + object);
        if (res1 != null) {
            log.info("已从缓存里面找到部门对象" + CACHE_DEPT_PROFIX + object);
            return res1;
        } else {
            Dept res2 = (Dept) joinPoint.proceed();
            CACHE_CONTAINER.put(CACHE_DEPT_PROFIX + res2.getId(), res2);
            log.info("未从缓存里面找到部门对象，去数据库查询并放到缓存" + CACHE_DEPT_PROFIX + res2.getId());
            return res2;
        }
    }

    /**
     * 更新切入
     */
    @Around(value = POINCUT_DEPT_UPDATE)
    public Boolean cacheDeptUpdate(ProceedingJoinPoint joinPoint) throws Throwable {
        //取出第一个参数
        Dept deptVo = (Dept) joinPoint.getArgs()[0];
        Boolean isSuccess = (Boolean) joinPoint.proceed();
        if (isSuccess) {
            Dept dept = (Dept) CACHE_CONTAINER.get(CACHE_DEPT_PROFIX + deptVo.getId());
            if (null == dept) {
                dept = new Dept();
            }
            BeanUtils.copyProperties(deptVo, dept);
            log.info("部门对象缓存已更新" + CACHE_DEPT_PROFIX + deptVo.getId());
            CACHE_CONTAINER.put(CACHE_DEPT_PROFIX + dept.getId(), dept);
        }
        return isSuccess;
    }



    /**
     * 删除切入
     */
//    @Around(value = POINCUT_DEPT_DELETE)
//    public Object cacheDeptDelete(ProceedingJoinPoint joinPoint) throws Throwable {
//        //取出第一个参数
//        Integer id = (Integer) joinPoint.getArgs()[0];
//        Boolean isSuccess = (Boolean) joinPoint.proceed();
//        if (isSuccess) {
//            //删除缓存
//            CACHE_CONTAINER.remove(CACHE_DEPT_PROFIX + id);
//            log.info("部门对象缓存已删除"+CACHE_DEPT_PROFIX + id);
//        }
//        return isSuccess;
//    }
}
