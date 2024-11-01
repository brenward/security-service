package com.bwardweb.security.security_service.controller;

import com.bwardweb.security.security_service.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@SessionAttributes("codeChallenge")
public class LoginController {

    private final ClientService clientService;

    public LoginController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/authorize")
    public String authorise(@RequestParam(name="client_id") String clientId, @RequestParam(name="response_type") String responseType,
                            @RequestParam(name="code_challenge", required=false) String codeChallenge, Model model){

        log.info("authorize request for " + clientId);

        if(!clientService.isClientValid(clientId, codeChallenge)){
            return "error";
        }

        if(StringUtils.isNotBlank(codeChallenge)){
            model.addAttribute("codeChallenge", codeChallenge);
        }

        return "login";
    }

    @PostMapping("/login")
    public void login(Model model, @RequestParam("username") String username, @RequestParam("password") String password){

        System.out.println("login");

        String codeChallenge = (String) model.getAttribute("codeChallenge");

        log.info(codeChallenge);

        //Credentials

        //TODO: validate credentials
        //TODO: store the auth code with the code challenge
        //TODO: invalidate session
        //TODO: redirect user to redirect uri with auth code
    }

}
