package com.bjpowernode.auth.service;

import com.bjpowernode.auth.model.Auth;

import java.util.List;

/**
 * @program: springboot_auth
 * @description
 * @author: zyh
 * @create: 2020-12-01 18:49
 * @version:1.0.0
 **/
public interface AuthService {

    List<Auth> queryAllAuth();

    List<Auth> queryByRoleId(Integer roleId);

    void save(Auth auth);

    Auth queryByAuthId(Integer authId);

    void saveUpdate(Auth auth);

    List<Auth> queryByUserId(Integer userId);
}
