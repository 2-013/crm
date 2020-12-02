package com.bjpowernode.auth.config;

import com.bjpowernode.auth.model.User;
import com.bjpowernode.auth.util.Constant;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: springboot_auth
 * @description
 * @author: zyh
 * @create: 2020-12-02 11:16
 * @version:1.0.0
 **/
public class LoginInterceptor implements HandlerInterceptor {

    /**登录之前拦载 */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
        System.out.println("------拦截器执行外---------");
        if (!ObjectUtils.allNotNull(user)) {
            //未登录跳转就去登录
            System.out.println("------拦截器执行---------");
            request.getRequestDispatcher("/login").forward(request,response);

            return false;
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
