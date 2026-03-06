package com.gustavogonzaga.system_gym.controller;

import com.gustavogonzaga.system_gym.dto.UserDTO;
import com.gustavogonzaga.system_gym.dto.auth.LoginDTO;
import com.gustavogonzaga.system_gym.dto.auth.RegisterDTO;
import com.gustavogonzaga.system_gym.dto.auth.TokenDTO;
import com.gustavogonzaga.system_gym.entities.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody RegisterDTO data){
        UserDTO user = authService.register(data);
        return ResponseEntity.ok(user);
    }
    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO data){
        TokenDTO token = authService.login(data);
        return ResponseEntity.ok(token);
    }
}
