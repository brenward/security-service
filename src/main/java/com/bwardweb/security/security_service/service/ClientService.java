package com.bwardweb.security.security_service.service;

import java.util.UUID;

public interface ClientService {
    boolean isClientValid(String clientId, String codeChallenge);

    String getClientRedirectUrl(UUID clientId);
}
