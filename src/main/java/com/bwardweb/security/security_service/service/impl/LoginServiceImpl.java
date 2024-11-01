package com.bwardweb.security.security_service.service.impl;

import com.bwardweb.security.security_service.entities.Login;
import com.bwardweb.security.security_service.repository.LoginRepository;
import com.bwardweb.security.security_service.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;

    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public String loginUser(final UUID userId, final UUID clientId, String codeChallenge) {


        Login login = Login
                .builder()
                .userId(userId)
                .clientId(clientId)
                .loginTime(LocalDateTime.now())
                .accessToken("testAccessToken")
                .codeChallenge(StringUtils.isNotBlank(codeChallenge) ? codeChallenge:null)
                .codeChallengeCreated(StringUtils.isNotBlank(codeChallenge) ? LocalDateTime.now():null)
                .build();

        loginRepository.save(login);

        return login.getAccessToken();
    }
}
