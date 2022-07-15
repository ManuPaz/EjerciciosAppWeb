package com.example.demorest.multiple_databases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PathMatchingConfigurationAdapter implements WebMvcConfigurer {
    @Autowired
    InterceptorPeticiones interceptorPeticiones;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorPeticiones);
    }
}
