package com.sxt.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sys")
public class SystemController {
    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(){

        return "system/index/login";
    }

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping("index")
    public String index(){

        return "system/index/index";
    }
    /**
     * 跳转到工作台
     * @return
     */
    @RequestMapping("toDeskManager")
    public String toDeskManager(){

        return "system/index/todeskManager";
    }
    /**
     * 跳转到日志管理
     * @return
     */
    @RequestMapping("toLoginfoManager")
    public String toLoginfoManager(){

        return "system/loginfo/loginfoManager";
    }

    /**
     * 跳转到公告管理
     * @return
     */
    @RequestMapping("toNoticeManager")
    public String toNoticeManager(){

        return "system/notice/noticeManager";
    }
}
