package com.carconnect.services;

import com.carconnect.models.User;
import com.carconnect.models.LoginResponse;
import com.carconnect.services.AuthService;
import com.carconnect.utils.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public LoginResponse authenticateUser(User user) {
        // Generate JWT Token
        String token = jwtUtil.generateToken(user.getEmail());

        // TODO: add and use Mapper?
        return new LoginResponse(
                "Login successful",
                user.getEmail(),
                token,
                user.getFirstName(),
                user.getLastName(),
                user.getId()
        );
    }
}
