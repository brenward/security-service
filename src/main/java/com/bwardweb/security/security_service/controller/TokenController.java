package com.bwardweb.security.security_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/oauth")
public class TokenController {
    @PostMapping("/token")
    public String getToken(){
        //Access code (code=)
        //grant type (grant_type=code)
        //code verifier (code_verifier)
        //client id (client_id)
        //client secret (client_secret)
        //redirect uri (redirect_uri)
        //refresh token?

        //TODO: validate client id
        //TODO: verify access code and (code verifier or client secret) or verify refresh token
        //TODO: generate idToken
        //TODO: generate and store access token
        //TODO: generate and store refresh token
        //TODO: return all in JWT

        return "token";
    }

    @PostMapping("/validate")
    public Boolean validateToken(){
        //access token
        //resource id

        //TODO: verify resource is registered
        //TODO: verify access token is valid and exists

        return true;
    }

}
