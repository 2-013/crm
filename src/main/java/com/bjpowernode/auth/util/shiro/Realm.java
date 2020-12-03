package com.bjpowernode.auth.util.shiro;

import com.bjpowernode.auth.model.User;
import com.bjpowernode.auth.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: springboot_auth
 * @description 用来提供登录与权限的数据源
 * @author: zyh
 * @create: 2020-12-03 10:26
 * @version:1.0.0
 **/
public class Realm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**权限认证 */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**登录验证 */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        //用户名查询用户返回，获得用户验证密码
        User user = userService.queryUserByName(upToken.getUsername());

        if (ObjectUtils.allNotNull(user)) {

            /*如果查出来了用户，说明用户名是有效的，那么是不是该校验密码是否有效了？
             * 将正确的密码放入返回值，它自动会比较是否相等
             * 如果相等则使用SecurityUtils这个工具将用户存入Shiro中，需要用的时候再用这个类取出来
             * 注意：已经被鉴定为合法的用户被称为Principal
             **/

            return new SimpleAuthenticationInfo(user,user.getUserPwd(),getName());
        }

        return null;
    }
}
