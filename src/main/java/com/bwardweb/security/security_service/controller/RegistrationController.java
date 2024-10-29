package com.bwardweb.security.security_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String registrationScreen(){
        //Show screen with Registration form
        //Screen captures details and posts form to /processRegistration

        return "register";
    }

    @PostMapping("/processRegistration")
    public String processRegistration(){
        //UserDetails

        //TODO: validate userdetails
        //TODO: Store in user table
        //TODO: redirect user to login

        return "login";
    }

}
