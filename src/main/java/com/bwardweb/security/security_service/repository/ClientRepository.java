package com.bwardweb.security.security_service.repository;

import com.bwardweb.security.security_service.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
