package com.bjpowernode.auth.controller;

import com.bjpowernode.auth.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springboot_auth
 * @description 首页
 * @author: zyh
 * @create: 2020-12-01 16:14
 * @version:1.0.0
 **/
@Controller
public class IndexController {

    /**跳转首页 */
    @RequestMapping("/index/home")
    public String home(){

        System.out.println("进入主页");
        return "index";
    }

    /**跳转工作台*/
    @RequestMapping("/right")
    public void right(){
    }

    /**员工无权限跳转页面 */
    @RequestMapping("/no_auth")
    public String noAuth(){
        System.out.println("-------------员工无权限跳转页面------------");
        return "noAuth";
    }


}
