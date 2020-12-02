package com.bjpowernode.auth.service;

import com.bjpowernode.auth.model.Role;

import java.util.List;

/**
 * @program: springboot_auth
 * @description
 * @author: zyh
 * @create: 2020-12-01 17:37
 * @version:1.0.0
 **/
public interface RoleService {

    List<Role> queryAllRole();

    /**查询 roleId角色信息*/
    Role queryByRoleId(Integer roleId);

    void save(Role role);

    void updateRole(Role role);

    List<Role> queryByUserId(Integer userId);
}
