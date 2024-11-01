package com.bwardweb.security.security_service.service.impl;

import com.bwardweb.security.security_service.entities.User;
import com.bwardweb.security.security_service.repository.UserRepository;
import com.bwardweb.security.security_service.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUsername(final String username) {
        return userRepository.findDistinctByUsername(username);
    }
}
