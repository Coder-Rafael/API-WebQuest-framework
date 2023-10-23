package br.com.apiWebQuest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apiWebQuest.Services.AuthorizationService;
import br.com.apiWebQuest.dto.LoginDTO;
import br.com.apiWebQuest.dto.UserDTO;
import br.com.apiWebQuest.model.UserModel;
import br.com.apiWebQuest.security.TokenService;
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthorizationService service;

    @Autowired
    TokenService tokenService;
    @Autowired
    AuthenticationManager authenticationManager;
    //localhost:8080/auth/login

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDTO userDTOreq){
        var usernamePassword = new UsernamePasswordAuthenticationToken(userDTOreq.getLogin(), userDTOreq.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserModel)auth.getPrincipal());

        return ResponseEntity.ok(new LoginDTO(token));  
    }

     //localhost:8080//auth/register
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDTO userDTOreq){
        if(this.service.loadUserByUsername(userDTOreq.getLogin()) != null)
            return ResponseEntity.badRequest().build();

            String encriptedPassowrd = new BCryptPasswordEncoder().encode(userDTOreq.getPassword());
            UserDTO userDto = new UserDTO(userDTOreq.getLogin(), encriptedPassowrd);
            service.save(userDto);
        return ResponseEntity.ok().build();  
    }


}
