package com.varaha.common.service;

import com.varaha.common.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getUserById(String id) {
        // Implementation to get user
        return new User();
    }
}
