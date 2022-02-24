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
                registry.addMapping("/juegos").allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET")
                        .maxAge(3600);
                registry.addMapping("/juegos/ciudad").allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET")
                        .maxAge(3600);
                registry.addMapping("/juegos/eliminar").allowedOrigins("http://localhost:4200")
                        .allowedMethods( "DELETE")
                        .maxAge(3600);
                registry.addMapping("/juegos/anadir").allowedOrigins("http://localhost:4200")
                        .allowedMethods( "POST")
                        .maxAge(3600);
                registry.addMapping("/juegos/modificar").allowedOrigins("http://localhost:4200")
                        .allowedMethods( "PUT")
                        .maxAge(3600);
            }

            ;
        };
    }

}
