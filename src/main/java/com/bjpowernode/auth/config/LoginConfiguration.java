package com.bjpowernode.auth.config;

import com.bjpowernode.auth.util.Constant;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: springboot_auth
 * @description 拦截器配置
 * @author: zyh
 * @create: 2020-12-02 11:13
 * @version:1.0.0
 **/
@Configuration
public class LoginConfiguration implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //拦截所有路径 排除路径
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns()//拦截所有路径
                .excludePathPatterns("/login")
                .excludePathPatterns("/saveLogin")
                .excludePathPatterns("/css/*")
                .excludePathPatterns("/imgs/*")
                .excludePathPatterns("/js/**");//排除路径
    }
}
