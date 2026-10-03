package com.taha.minihelpdeskapi.auth;


import com.taha.minihelpdeskapi.entity.User;
import com.taha.minihelpdeskapi.enums.Role;
import com.taha.minihelpdeskapi.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public User register(RegisterRequest request) {

        var user = User.builder()
                .username(request.username())
                .password(request.password())
                .role(Role.USER)
                .build();

        return userService.save(user);
    }

    public Authentication authenticate(LoginRequest request) {

        var authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                );

        return authenticationManager.authenticate(authenticationToken);
    }
}