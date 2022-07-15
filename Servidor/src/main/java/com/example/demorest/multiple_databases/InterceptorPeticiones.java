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
    private  String defaultDatabaseName;
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) throws Exception {
        System.out.println("In preHandle we are Intercepting the Request");
        System.out.println("____________________________________________");
        final String databaseName= request.getHeader("databaseName");
        if (databaseName  != null) {
            DatabaseContext.setCurrentSchema(databaseName);
            return true;
        }
        DatabaseContext.setCurrentSchema(defaultDatabaseName);
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        DatabaseContext.clear();
    }
}
