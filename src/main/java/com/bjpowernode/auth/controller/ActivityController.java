package com.bjpowernode.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springboot_auth
 * @description 市厂
 * @author: zyh
 * @create: 2020-12-01 17:07
 * @version:1.0.0
 **/
@Controller
@RequestMapping("/activity")
public class ActivityController {

    /**跳转市厂 */
    @RequestMapping("/list")
    public String home(){

        System.out.println("-------------市厂页面------------");
        return "/activity/list";
    }
}
