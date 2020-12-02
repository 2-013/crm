package com.bjpowernode.auth.service;

import com.bjpowernode.auth.mapper.RoleAuthMapper;
import com.bjpowernode.auth.util.RoleAuthTwo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: springboot_auth
 * @description
 * @author: zyh
 * @create: 2020-12-01 20:36
 * @version:1.0.0
 **/
@Service
@Slf4j
public class RoleAuthServiceImpl implements RoleAuthService {

    @Autowired
    RoleAuthMapper roleAuthMapper;

    /**将角色被给与的权限封装入arraylist一次性插入数据库 */
    @Override
    public void saveAuthByRoleId(Integer roleId, int[] authIds) {
        //以防止是更新角色权限，先将角色id相关权限删除
        roleAuthMapper.deleteByRoleId(roleId);
        roleAuthMapper.addAuthByRoleId(roleId,authIds);
    }



}
