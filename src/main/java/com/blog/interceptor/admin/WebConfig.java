package com.blog.interceptor.admin;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * 拦截的配置器
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        System.out.println("开始拦截");
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                //排除哪些不需要拦截
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login");
    }
}
