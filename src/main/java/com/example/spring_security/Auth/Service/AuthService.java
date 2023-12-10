package com.example.spring_security.Auth.Service;

import com.example.spring_security.Auth.Jwt.JwtService;
import com.example.spring_security.Auth.Model.Request.AuthRequest;
import com.example.spring_security.Auth.Model.Request.RegisterRequest;
import com.example.spring_security.Auth.Model.Response.AuthResponse;
import com.example.spring_security.Model.Role;
import com.example.spring_security.Model.User;
import com.example.spring_security.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthResponse register(RegisterRequest request) {
        User user=User.builder()
                .id(request.getId())
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(Role.USER)//stactic role
                .build();
        userRepo.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder().token(jwtToken).build();
    }

    public AuthResponse authenticate(AuthRequest request) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )

            );
            var user=userRepo.findByEmail(request.getEmail())
                    .orElseThrow(()-> new UsernameNotFoundException("fuck this"));

            var jwtoken= jwtService.generateToken(user);
            return AuthResponse.builder().token(jwtoken).build();
        } catch (AuthenticationException e) {
            System.out.println("fuck thiss");
            throw new RuntimeException(e);
        }
    }
}
