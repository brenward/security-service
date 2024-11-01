package com.bwardweb.security.security_service.repository;

import com.bwardweb.security.security_service.entities.Client;
import com.bwardweb.security.security_service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findDistinctByUsername(final String username);
}
