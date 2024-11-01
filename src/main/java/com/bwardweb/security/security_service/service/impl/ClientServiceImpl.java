package com.bwardweb.security.security_service.service.impl;

import com.bwardweb.security.security_service.entities.Client;
import com.bwardweb.security.security_service.repository.ClientRepository;
import com.bwardweb.security.security_service.service.ClientService;
import org.springframework.stereotype.Service;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public boolean isClientValid(final String clientId, final String codeChallenge) {
        Optional<Client> clientOptional = clientRepository.findById(UUID.fromString(clientId));

        return clientOptional.isPresent()
                && StringUtils.isNotBlank(clientOptional.get().getRedirectUrl())
                && (StringUtils.isNotBlank(codeChallenge) || StringUtils.isNotBlank(clientOptional.get().getClientSecret()));
    }
}
