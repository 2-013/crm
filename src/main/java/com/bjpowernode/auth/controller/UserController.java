package com.bjpowernode.auth.controller;

import com.bjpowernode.auth.model.*;
import com.bjpowernode.auth.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: springboot_auth
 * @description 员工管理
 * @author: zyh
 * @create: 2020-12-01 17:03
 * @version:1.0.0
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @Autowired
    RoleService roleService;

    @Autowired
    UserRoleService userRoleService;
    @Autowired
    UserAuthService userAuthService;

    /**跳转首页 */
    @RequestMapping("/list")
    public String home(Model model){
        List<User> userList = userService.queryAllUser();
        model.addAttribute("userList",userList);
        System.out.println("-------------员工页面------------");
        return "user/list";
    }

    /**员工添加跳转 */
    @RequestMapping("/add")
    public String add(Model model){
        User user = new User();
        model.addAttribute("user",user);
        System.out.println("-------------员工添加跳转------------");
        return "user/edit";
    }

    /**员工添加保存 */
    @RequestMapping("/save")
    public String save(User user){

        userService.save(user);
        System.out.println("-------------员工添加保存------------");
        return "redirect:list";
    }

    /**员工更新查询 */
    @RequestMapping("/update")
    public String update(Integer userId,Model model){

        User user = userService.queryByUserId(userId);
        model.addAttribute("user",user);
        System.out.println("-------------员工更新查询------------");
        return "user/edit";
    }

    /**员工更新保存 */
    @RequestMapping("/saveUpdate")
    public String saveUpdate(User user){

       userService.saveUpdate(user);
        System.out.println("-------------员工更新保存------------");
        return "redirect:list";
    }

    /**员工授权跳转*/
    @RequestMapping("/auth")
    public String auth(Integer userId,Model model){

        //查询所有权限，查询所有角色
        List<Auth> authList = authService.queryAllAuth();
        List<Role> roleList = roleService.queryAllRole();

        //查询用户，查询权限，查询角色
        User user = userService.queryByUserId(userId);
        List<Auth> authUserList = authService.queryByUserId(userId);
        List<Role> roleUserList = roleService.queryByUserId(userId);

        //员工所有权限
        List<Integer> authUserIds = new ArrayList<>();
        for(Auth auth : authUserList){
            authUserIds.add(auth.getAuthId());
        }
        user.setAuthIds(authUserIds);

        //员工所有角色
        List<Integer> roleUserIds = new ArrayList<>();
        for (Role role:roleUserList){
            roleUserIds.add(role.getRoleId());
        }
        user.setRoleIds(roleUserIds);

        model.addAttribute("user",user);
        model.addAttribute("authList",authList);
        model.addAttribute("roleList",roleList);

        System.out.println("-------------员工授权跳转------------");
        return "user/auth";
    }

    /**更新员工角色，权限 */
    @RequestMapping("/saveAuth")
    public String saveAuth(User user, @RequestParam(value = "authIds",required = false) int[] authIds,
                           @RequestParam(value = "roleIds",required = false) int[] roleIds){

        userService.saveUpdate(user);
        userAuthService.saveUserAuthIds(user.getUserId(),authIds);
        userRoleService.saveUserRoleIds(user.getUserId(),roleIds);
        System.out.println("-------------更新员工角色，权限------------");
        return "redirect:list";
    }




}
