package com.example.spring_security.Auth.Controller;
import com.example.spring_security.Auth.Service.AuthService;
import com.example.spring_security.Auth.Model.Request.AuthRequest;
import com.example.spring_security.Auth.Model.Request.RegisterRequest;
import com.example.spring_security.Auth.Model.Response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping ("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
            return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping ("/authenticate")
    public ResponseEntity<AuthResponse> authenticate (@RequestBody AuthRequest request)
    {
        return ResponseEntity.ok(authService.authenticate(request));
    }

}
