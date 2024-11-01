package com.bwardweb.security.security_service.service;

public interface ClientService {
    boolean isClientValid(String clientId, String codeChallenge);
}
