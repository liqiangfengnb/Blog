package com.blog.interceptor.home;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * 拦截的配置器
 */
@Configuration
public class WebConfig2 implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor2())
                .addPathPatterns("/home/**")
                //排除哪些不需要拦截
                .excludePathPatterns("/home")
//                .excludePathPatterns("/home/index")
                .excludePathPatterns("/home/login2")
                .excludePathPatterns("/home/login");
    }
}
