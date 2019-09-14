package com.lizhi.guide.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/project_document/**").addResourceLocations("classpath:/uploads/project_document/");
        registry.addResourceHandler("/user_images/**").addResourceLocations("classpath:/uploads/user_images/");
        registry.addResourceHandler("/uploads/**").addResourceLocations("classpath:/uploads/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");

    }
}
