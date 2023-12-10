package com.example.spring_security.Controller.Demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping()
    public ResponseEntity<String> hello()
    {
        return  ResponseEntity.ok("hello bro");
    }
}
