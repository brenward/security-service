package com.bwardweb.security.security_service.repository;

import com.bwardweb.security.security_service.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoginRepository extends JpaRepository<Login, UUID> {
}
