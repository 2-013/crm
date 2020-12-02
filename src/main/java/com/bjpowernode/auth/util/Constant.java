package com.bjpowernode.auth.util;

/**
 * @program: springboot_auth
 * @description 常量
 * @author: zyh
 * @create: 2020-12-01 20:00
 * @version:1.0.0
 **/
public class Constant {

    /**登录用户 */
    public static final String LOGIN_USER = "LOGIN_USER";

    /** 角色权限*/
    public static final String ROLE_AUTH="ROLE_AUTH";

    // 不验证URL anon：不验证/authc：受控制的
    public static final String NO_INTERCEPTOR_PATH =".*/((.css)|(.js)|(imgs)|(login)).*";
}
