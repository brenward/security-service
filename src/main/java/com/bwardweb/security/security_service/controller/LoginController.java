package com.bwardweb.security.security_service.controller;

import com.bwardweb.security.security_service.entities.User;
import com.bwardweb.security.security_service.service.ClientService;
import com.bwardweb.security.security_service.service.LoginService;
import com.bwardweb.security.security_service.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@Controller
@SessionAttributes({"code_challenge", "client_id"})
public class LoginController {

    private final ClientService clientService;

    private final UserService userService;

    private final LoginService loginService;

    public LoginController(ClientService clientService, UserService userService, LoginService loginService) {
        this.clientService = clientService;
        this.userService = userService;
        this.loginService = loginService;
    }

    @GetMapping("/authorize")
    public String authorise(@RequestParam(name="client_id") String clientId, @RequestParam(name="response_type") String responseType,
                            @RequestParam(name="code_challenge", required=false) String codeChallenge, final Model model){

        log.info("authorize request for " + clientId);

        if(!clientService.isClientValid(clientId, codeChallenge)){
            return "error";
        }

        model.addAttribute("client_id", UUID.fromString(clientId));
        if(StringUtils.isNotBlank(codeChallenge)){
            model.addAttribute("code_challenge", codeChallenge);
        }

        return "login";
    }

    @PostMapping("/login")
    public String login(final Model model, final HttpSession httpSession, @RequestParam("username") String username, @RequestParam("password") String password){

        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return "redirect:/error";
        }

        log.info("Attempting to login " + username);

        User user = userService.getUserByUsername(username);
        if(user == null || !password.equals(user.getPassword())){
            return "/error";
        }

        String authCode = loginService.loginUser(user.getUserId(),
                (UUID) model.getAttribute("client_id"),
                (String) model.getAttribute("code_challenge"));

        String redirectUrl = clientService.getClientRedirectUrl(
                (UUID) model.getAttribute("client_id"));

        model.addAttribute("code_challenge", "");
        model.addAttribute("client_id","");
        httpSession.invalidate();

        if(redirectUrl == null){
            return "/error";
        }
        return "redirect:"+ redirectUrl + authCode;
    }

}
