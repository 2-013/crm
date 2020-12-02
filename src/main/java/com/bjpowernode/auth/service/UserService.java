package com.bjpowernode.auth.service;

import com.bjpowernode.auth.model.User;

import java.util.List;

/**
 * @program: springboot_auth
 * @description
 * @author: zyh
 * @create: 2020-12-01 18:42
 * @version:1.0.0
 **/

public interface UserService {
    List<User> queryAllUser();

    void save(User user);

    User queryByUserId(Integer userId);

    void saveUpdate(User user);

    User queryUserByPwd(User user);
}
