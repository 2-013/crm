package com.bjpowernode.auth.service;

import com.bjpowernode.auth.model.Auth;
import com.bjpowernode.auth.model.RoleAuth;

import java.util.List;

/**
 * @program: springboot_auth
 * @description
 * @author: zyh
 * @create: 2020-12-01 20:34
 * @version:1.0.0
 **/
public interface RoleAuthService {

    /**角色权限添加 */
    void saveAuthByRoleId(Integer roleId, int[] authIds);


}
