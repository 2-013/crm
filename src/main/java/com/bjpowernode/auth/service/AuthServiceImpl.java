package com.bjpowernode.auth.service;

import com.bjpowernode.auth.mapper.AuthMapper;
import com.bjpowernode.auth.model.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springboot_auth
 * @description
 * @author: zyh
 * @create: 2020-12-01 18:50
 * @version:1.0.0
 **/
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthMapper authMapper;

    /**查询所有的权限 */
    @Override
    public List<Auth> queryAllAuth() {
        return authMapper.selectAllAuth();
    }

    /**左外联接查询角色所有的权限 */
    @Override
    public List<Auth> queryByRoleId(Integer roleId) {
        return authMapper.selectByRoleId(roleId);
    }

    /**保存添加权限 */
    @Override
    public void save(Auth auth) {
        authMapper.insertSelective(auth);
    }

    /**查询要更新的权限 */
    @Override
    public Auth queryByAuthId(Integer authId) {
        return authMapper.selectByPrimaryKey(authId);
    }

    /** 保存更新权限*/
    @Override
    public void saveUpdate(Auth auth) {
        authMapper.updateByPrimaryKeySelective(auth);
    }

    /**左外联接查询员工所有的权限 */
    @Override
    public List<Auth> queryByUserId(Integer userId) {
        return authMapper.queryByUserId(userId);
    }

    /**登录本身的权限和所拥有角色的权限 */
    @Override
    public List<Auth> queryAllAuthByUserId(Integer userId) {
        return authMapper.selectAllAuthByUserId(userId);
    }


}
