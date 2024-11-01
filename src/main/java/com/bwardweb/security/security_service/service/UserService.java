package com.bwardweb.security.security_service.service;

import com.bwardweb.security.security_service.entities.User;

public interface UserService {
    User getUserByUsername(String username);
}
