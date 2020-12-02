package com.bjpowernode.auth.service;

import com.bjpowernode.auth.model.Role;

import java.util.List;

/**
 * @program: springboot_auth
 * @description
 * @author: zyh
 * @create: 2020-12-02 09:35
 * @version:1.0.0
 **/
public interface UserRoleService {

    void saveUserRoleIds(int userId,int[] roleIds);
}
