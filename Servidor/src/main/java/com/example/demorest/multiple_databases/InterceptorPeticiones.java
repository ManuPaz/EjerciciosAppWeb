package com.example.demorest.multiple_databases;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class InterceptorPeticiones implements HandlerInterceptor {
    @Value("${bd.databasename}")
    private String defaultDatabaseName;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) throws Exception {
        final String databaseName = request.getHeader("databaseName") != null ? request.getHeader("databaseName") : defaultDatabaseName;
        DatabaseContext.setCurrentSchema(databaseName);
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        DatabaseContext.clear();
    }
}
