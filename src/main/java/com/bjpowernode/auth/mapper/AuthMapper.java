package com.bjpowernode.auth.mapper;

import com.bjpowernode.auth.model.Auth;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AuthMapper {
    int deleteByPrimaryKey(Integer authId);

    int insert(Auth record);

    int insertSelective(Auth record);

    Auth selectByPrimaryKey(Integer authId);

    int updateByPrimaryKeySelective(Auth record);

    int updateByPrimaryKey(Auth record);

    /**查询所有权限 */
    List<Auth> selectAllAuth();

    /**左外联接查询所有的角色权限 */
    List<Auth> selectByRoleId(Integer roleId);

    /**左外联接查询所有的用户权限 */
    List<Auth> queryByUserId(Integer userId);

    /**登录本身的权限和所拥有角色的权限 */
    List<Auth> selectAllAuthByUserId(Integer userId);
}