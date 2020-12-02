package com.bjpowernode.auth.service;

import com.bjpowernode.auth.mapper.UserAuthMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springboot_auth
 * @description
 * @author: zyh
 * @create: 2020-12-02 10:30
 * @version:1.0.0
 **/
@Service
@Slf4j
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    UserAuthMapper userAuthMapper;

    @Override
    public void saveUserAuthIds(int userId,int[] authIds) {
        userAuthMapper.insertUserAuthIds(userId,authIds);
    }
}
