package com.example.demorest.api;

import com.example.demorest.services.JuegosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("")
public class JuegosApiController extends JuegosApi {
    @Autowired
    JuegosService juegosService;
    private final com.example.demorest.api.JuegosApiDelegate delegate;

    public JuegosApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) com.example.demorest.api.JuegosApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new com.example.demorest.api.JuegosApiDelegate() {
        });
    }


    public JuegosApiDelegate getDelegate() {
        return delegate;
    }

}
