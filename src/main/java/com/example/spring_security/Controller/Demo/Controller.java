package com.example.spring_security.Controller.Demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/demo")
public class Controller {

    @GetMapping("/hello")
    public String hello()
    {
        return ("<h1>Hello</h1>");
    }
}
