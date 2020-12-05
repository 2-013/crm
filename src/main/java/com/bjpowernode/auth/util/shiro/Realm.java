package com.bjpowernode.auth.util.shiro;

import com.bjpowernode.auth.model.Auth;
import com.bjpowernode.auth.model.User;
import com.bjpowernode.auth.service.AuthService;
import com.bjpowernode.auth.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    @Autowired
    AuthService authService;

    /**权限认证 */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        //为当前用户添加权限，使之能够访问相关路径
        //authorizationInfo.addStringPermission("user_list");

        //取出当前登录用户，并查其所本身的权限和所拥有角色的权限
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        List<Auth> authList = authService.queryAllAuthByUserId(user.getUserId());

        //遍历所有的可访问权限，并将编码放入authorizationInfo
        for(Auth auth : authList){
            authorizationInfo.addStringPermission(auth.getAuthCode());
        }

        return authorizationInfo;
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
