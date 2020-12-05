package com.bjpowernode.auth.controller;

import com.bjpowernode.auth.model.User;
import com.bjpowernode.auth.service.UserService;
import com.bjpowernode.auth.util.Constant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: springboot_auth
 * @description 登录控制层synchronized
 * @author: zyh
 * @create: 2020-12-01 16:13
 * @version:1.0.0
 **/
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordService passwordService;

    @RequestMapping("login")
    public void login(){

        System.out.println(1);
    }

    @RequestMapping("/saveLogin")
    public String saveLogin(User user,String remeber){

        //构建一个由用户名和密码组成的对象，我们称这个对象为令牌
        UsernamePasswordToken up = new UsernamePasswordToken(user.getUserName(), user.getUserPwd().toCharArray());
        up.setRememberMe("1".equals(remeber));

        try {
            //Subject一般指登录人,不一定是一个具体的人，与当前应用交互的任何东西都是 Subject，如网络爬虫，机器人等
            Subject subject = SecurityUtils.getSubject();
            //执行登录人的登录方法，这个方法的调用会调用Realm的doGetAuthenticationInfo()
            subject.login(up);

        } catch (AuthenticationException e) {
            user.setMsg("登录失败，帐户或密码错误");
            return "login";
        }

        /*User userLogin = userService.queryUserByPwd(user);
        request.getSession().setAttribute(Constant.LOGIN_USER,userLogin);
        System.out.println(userLogin);*/

        return "redirect:/index/home";
    }

    @RequestMapping("logout")
    public String logout(){

        //举一反三，退出如法炮制既可
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        return "login";
    }


}
