package com.bjpowernode.auth.controller;

import com.bjpowernode.auth.model.User;
import com.bjpowernode.auth.service.UserService;
import com.bjpowernode.auth.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: springboot_auth
 * @description 登录控制层
 * @author: zyh
 * @create: 2020-12-01 16:13
 * @version:1.0.0
 **/
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public void login(){
    }

    @RequestMapping("/saveLogin")
    public String saveLogin(User user, HttpServletRequest request){

        User userLogin = userService.queryUserByPwd(user);
        request.getSession().setAttribute(Constant.LOGIN_USER,userLogin);
        System.out.println(userLogin);

        return "redirect:/index/home";
    }

}
