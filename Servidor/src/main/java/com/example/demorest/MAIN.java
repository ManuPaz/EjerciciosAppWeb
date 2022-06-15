package com.example.demorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MAIN {

    public static void main(String[] args) {
        SpringApplication.run(MAIN.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                //clean code: sustituir literals por variables
                final int   maxAge=3600;
                final String baseUrl="http://localhost:3000";
                registry.addMapping("/juegos").allowedOrigins(baseUrl).allowedMethods("GET").maxAge(maxAge);
                registry.addMapping("/juegos/buscar").allowedOrigins(baseUrl).allowedMethods("GET").maxAge(maxAge);
                registry.addMapping("/juegos/eliminar").allowedOrigins(baseUrl).allowedMethods("POST").maxAge(maxAge);
                registry.addMapping("/juegos/anadir").allowedOrigins(baseUrl).allowedMethods("POST").maxAge(maxAge);
                registry.addMapping("/juegos/modificar").allowedOrigins(baseUrl).allowedMethods("POST").maxAge(maxAge);
                registry.addMapping("/juegos/filtrar").allowedOrigins(baseUrl).allowedMethods("POST").maxAge(maxAge);
                registry.addMapping("/juegos/login").allowedOrigins(baseUrl).allowedMethods("POST").maxAge(maxAge);
            }

        };
    }

}
