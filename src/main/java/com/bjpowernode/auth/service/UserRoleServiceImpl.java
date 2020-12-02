package com.bjpowernode.auth.service;

import com.bjpowernode.auth.mapper.UserMapper;
import com.bjpowernode.auth.mapper.UserRoleMapper;
import com.bjpowernode.auth.model.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springboot_auth
 * @description
 * @author: zyh
 * @create: 2020-12-02 09:46
 * @version:1.0.0
 **/
@Service
@Slf4j
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;


    @Override
    public void saveUserRoleIds(int userId,int[] roleIds) {
        userRoleMapper.insertUserRoleIds(userId,roleIds);
    }
}
