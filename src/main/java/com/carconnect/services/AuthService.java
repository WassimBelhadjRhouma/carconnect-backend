package com.carconnect.services;

import com.carconnect.models.User;
import com.carconnect.models.LoginResponse;

public interface AuthService {
    LoginResponse authenticateUser(User user);
}
