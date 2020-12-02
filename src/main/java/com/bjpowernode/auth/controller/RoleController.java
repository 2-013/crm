package com.bjpowernode.auth.controller;

import com.bjpowernode.auth.model.Auth;
import com.bjpowernode.auth.model.Role;
import com.bjpowernode.auth.model.RoleAuth;
import com.bjpowernode.auth.service.AuthService;
import com.bjpowernode.auth.service.RoleAuthService;
import com.bjpowernode.auth.service.RoleService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: springboot_auth
 * @description 角色
 * @author: zyh
 * @create: 2020-12-01 17:06
 * @version:1.0.0
 **/
@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    AuthService authService;

    @Autowired
    RoleAuthService roleAuthService;

    /**跳转首页 */
    @RequestMapping("/list")
    public String home(Model model){

        /**查询所有角色 */
       List<Role> roleList = roleService.queryAllRole();
       model.addAttribute("roleList",roleList);

        System.out.println("-------------角色页面------------");
        return "role/list";
    }

    /**跳转添加角色页面 */
    @RequestMapping("add")
    String add(Model model){

        Role role = new Role();
        role.setRoleStatus(1);
        model.addAttribute("role",role);
        //查询所有的权限
        model.addAttribute("authList",authService.queryAllAuth());
        return "role/edit";
    }

    /**保存添加的角色 */
    @RequestMapping("save")
    String save(Role role,int[] authIds){

        //添加角色返回id，并添加角色所拥有的权限
        roleService.save(role);
        System.out.println(role.getRoleId());
        roleAuthService.saveAuthByRoleId(role.getRoleId(),authIds);

        return "redirect:list";
    }

    /**跳转更新角色权限页面 */
    @RequestMapping("update")
    String updateQuery(Integer roleId,Model model){

        //查询角色信息，查询角色权限信息
        Role role = roleService.queryByRoleId(roleId);
        List<Auth> authList = authService.queryAllAuth();
        //左处联接查询角色所有的权限
        List<Auth> authRoleList = authService.queryByRoleId(roleId);
        List<Integer> authIds = new ArrayList<>();

        for(Auth auth : authRoleList){
            authIds.add(auth.getAuthId());
        }
        role.setAuthIds(authIds);

        model.addAttribute("role",role);
        model.addAttribute("authList",authList);
        //model.addAttribute("roleAuthList",roleAuthList);
        return "role/edit";
    }

    /**保存更新的角色 */
    @RequestMapping("saveUpdate")
    String saveUpdate(Role role,int[] authIds){

        //更新角色表，向权限表重新写入
        roleService.updateRole(role);
        roleAuthService.saveAuthByRoleId(role.getRoleId(),authIds);

        return "redirect:list";
    }

}
