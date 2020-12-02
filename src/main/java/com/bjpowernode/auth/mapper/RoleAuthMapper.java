package com.bjpowernode.auth.mapper;

import com.bjpowernode.auth.model.RoleAuth;
import com.bjpowernode.auth.util.RoleAuthTwo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleAuthMapper {
    int deleteByPrimaryKey(Integer roleAuthId);

    int insert(RoleAuth record);

    int insertSelective(RoleAuth record);

    RoleAuth selectByPrimaryKey(Integer roleAuthId);

    int updateByPrimaryKeySelective(RoleAuth record);

    int updateByPrimaryKey(RoleAuth record);

    /**给角色添加权限 */
    void addAuthByRoleId(Integer roleId, int[] authIds);

    /**删除角色id相关权限 */
    void deleteByRoleId(Integer roleId);
}