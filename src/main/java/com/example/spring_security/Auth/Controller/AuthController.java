package com.example.spring_security.Auth;
import com.example.spring_security.Model.Request.AuthRequest;
import com.example.spring_security.Model.Request.RegisterRequest;
import com.example.spring_security.Model.Response.AuthResponse;
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
