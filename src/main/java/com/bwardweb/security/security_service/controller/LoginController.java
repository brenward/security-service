package com.bwardweb.security.security_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/authorize")
    public String authorise(@RequestParam(name="client_id") String clientId, @RequestParam(name="response_type") String responseType,
                            @RequestParam(name="code_challenge", required=false) String codeChallenge){

        System.out.println("authorize");

        //response type (response_type=code)
        //client id (client_id=)
        //redirect uri (redirect_uri=)
        //code challenge (code_challenge=)

        //TODO: validate client id and redirect uri (if client secret present)
        //TODO: store code challenge in session
        //TODO: forward to login

        return "login";
    }

    @PostMapping("/login")
    public void login(){

        System.out.println("login");

        //Credentials

        //TODO: validate credentials
        //TODO: store the auth code with the code challenge
        //TODO: invalidate session
        //TODO: redirect user to redirect uri with auth code
    }

}
