package com.bjpowernode.auth.util;

/**
 * @program: springboot_auth
 * @description
 * @author: zyh
 * @create: 2020-12-01 21:44
 * @version:1.0.0
 **/
public class RoleAuthTwo {

    private Integer roleId;
    private int authId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }
}
