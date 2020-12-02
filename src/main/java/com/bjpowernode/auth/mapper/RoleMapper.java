package com.bjpowernode.auth.mapper;

import com.bjpowernode.auth.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**查询所有角色 */
    List<Role> selectAllRole();

    List<Role> selectByUserId(Integer userId);

}