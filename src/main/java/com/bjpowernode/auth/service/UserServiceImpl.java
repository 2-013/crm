package com.bjpowernode.auth.service;

import com.bjpowernode.auth.mapper.UserMapper;
import com.bjpowernode.auth.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.credential.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springboot_auth
 * @description
 * @author: zyh
 * @create: 2020-12-02 09:10
 * @version:1.0.0
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordService passwordService;

    @Override
    public List<User> queryAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public void save(User user) {
        userMapper.insertSelective(user);
    }

    /**员工更新查询 */
    @Override
    public User queryByUserId(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    /**员工更新保存 */
    @Override
    public void saveUpdate(User user) {
        user.setUserPwd(passwordService.encryptPassword(user.getUserPwd()));
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**查询登录用户是否存在 */
    @Override
    public User queryUserByPwd(User user) {
        user.setUserPwd(passwordService.encryptPassword(user.getUserPwd()));
        return userMapper.selectByPwd(user.getUserName(),user.getUserPwd());
    }

    @Override
    public User queryUserByName(String username) {
        return userMapper.selectByName(username);
    }
}
