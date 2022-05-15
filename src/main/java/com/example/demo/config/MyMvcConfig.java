package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("index");
        registry.addViewController("/main").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/tables.html").setViewName("tables");
        registry.addViewController("/tableUsers.html").setViewName("tableUsers");
        registry.addViewController("/Implement.html").setViewName("Implement");

    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/tables.html","/queryUserList","/queryWorkerList","/login.html","/user/login","/css/**","/img/**","/js/**","/scss/**","/vendor/**");
//    }
}
