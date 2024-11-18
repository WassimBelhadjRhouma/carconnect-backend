package com.carconnect.controllers;

import com.carconnect.models.LoginResponse;
import com.carconnect.models.User;
import com.carconnect.repositories.UserRepository;
import com.carconnect.services.AuthService;
import com.carconnect.services.UserService;
import com.carconnect.utils.JwtUtil;
import com.carconnect.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;
    private JwtUtil jwtUtil;

    @Autowired
    public AuthController(UserService userService, AuthService authService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        // Extract email and password from request
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        // Check if the user exists in the database
        Optional<User> userOptional = userService.findUserByEmail(email);
        if (userOptional.isEmpty() || !PasswordUtil.verifyPassword(password, userOptional.get().getPassword())) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid email or password"));
        }

        User user = userOptional.get();
        LoginResponse response = authService.authenticateUser(user);
        return ResponseEntity.ok(response);
    }
}
