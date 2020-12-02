package com.bjpowernode.auth.service;

/**
 * @program: springboot_auth
 * @description
 * @author: zyh
 * @create: 2020-12-02 09:35
 * @version:1.0.0
 **/
public interface UserAuthService {

    void saveUserAuthIds(int userId,int[] authIds);
}
