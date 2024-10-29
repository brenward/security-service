package com.bwardweb.security.security_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/authorize")
    public String authorise(){
        //response type
        //client id
        //redirect uri
        //code challenge
        //code challenge method

        //TODO: validate client id and redirect uri
        //TODO: store code challenge in session
        //TODO: forward to login

        return "login";
    }

    @PostMapping("/login")
    public void login(){
        //Credentials

        //TODO: validate credentials
        //TODO: store the auth code with the code challenge
        //TODO: invalidate session
        //TODO: redirect user to redirect uri with auth code
    }

}
