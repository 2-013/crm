package com.bjpowernode.auth.service;

import com.bjpowernode.auth.mapper.RoleMapper;
import com.bjpowernode.auth.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springboot_auth
 * @description
 * @author: zyh
 * @create: 2020-12-01 17:37
 * @version:1.0.0
 **/
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleMapper roleMapper;

    /**查询所有的角色 */
    @Override
    public List<Role> queryAllRole() {
        return roleMapper.selectAllRole();
    }


    /**查询 roleId角色信息*/
    @Override
    public Role queryByRoleId(Integer roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }


    /**保存角色*/
    @Override
    public void save(Role role) {
        roleMapper.insertSelective(role);
    }

    /**更新角色表 */
    @Override
    public void updateRole(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
    }

    /** 查询员工所有角色*/
    @Override
    public List<Role> queryByUserId(Integer userId) {
        return roleMapper.selectByUserId(userId);
    }
}
