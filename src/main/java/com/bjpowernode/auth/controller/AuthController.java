package com.bjpowernode.auth.controller;

import com.bjpowernode.auth.model.Auth;
import com.bjpowernode.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: springboot_auth
 * @description 权限
 * @author: zyh
 * @create: 2020-12-01 17:08
 * @version:1.0.0
 **/
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    /**权限管理 */
    @RequestMapping("/list")
    public String home(Model model){

        List<Auth> authList = authService.queryAllAuth();
        model.addAttribute("authList",authList);
        System.out.println("-------------权限页面------------");
        return "/auth/list";
    }

    /**权限管理 */
    @RequestMapping("/add")
    public String add(Model model){

        Auth auth = new Auth();
        auth.setAuthStatus(1);
        model.addAttribute("auth",auth);
        System.out.println("-------------跳转新增权限------------");
        return "auth/edit";
    }

    /**保存权限 */
    @RequestMapping("/save")
    public String save( Auth auth){
        authService.save(auth);
        System.out.println("-------------保存权限------------");
        return "redirect:list";
    }

    /**权限更新查询 */
    @RequestMapping("/update")
    public String update(Integer authId,Model model){
        Auth auth = authService.queryByAuthId(authId);
        model.addAttribute("auth",auth);
        System.out.println("-------------权限更新查询------------");
        return "auth/edit";
    }

    /**保存更新权限 */
    @RequestMapping("/saveUpdate")
    public String saveUpdate( Auth auth){
        authService.saveUpdate(auth);
        System.out.println("-------------保存更新权限------------");
        return "redirect:list";
    }


}
