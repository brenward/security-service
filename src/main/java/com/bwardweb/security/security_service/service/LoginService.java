package com.bwardweb.security.security_service.service;

import java.util.UUID;

public interface LoginService {
    String loginUser(UUID userId, final UUID clientId, String codeChallenge);
}
