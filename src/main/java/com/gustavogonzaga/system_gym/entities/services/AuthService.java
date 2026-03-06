package com.gustavogonzaga.system_gym.entities.services;

import com.gustavogonzaga.system_gym.dto.UserDTO;
import com.gustavogonzaga.system_gym.dto.auth.LoginDTO;
import com.gustavogonzaga.system_gym.dto.auth.RegisterDTO;
import com.gustavogonzaga.system_gym.dto.auth.TokenDTO;
import com.gustavogonzaga.system_gym.entities.User;
import com.gustavogonzaga.system_gym.repository.UserRepository;
import com.gustavogonzaga.system_gym.security.JwtServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtServices jwtServices;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO register(RegisterDTO data){
        if (userRepository.existsByEmail(data.getEmail())){
            throw new RuntimeException("Email já cadastrado");
        }
        User user = new User();
        user.setNome(data.getNome());
        user.setEmail(data.getEmail());
        user.setPassword(passwordEncoder.encode(data.getPassword()));
        User salvo = userRepository.save(user);

        return new UserDTO(salvo.getId(), salvo.getNome());
    }
    public TokenDTO login(LoginDTO data){
        User user = userRepository.findByEmail(data.getEmail()).orElseThrow(() -> new RuntimeException("Usuario não Encontrado"));
        if (!passwordEncoder.matches(data.getPassword(), user.getPassword())){
            throw new RuntimeException("Senha Invalida");
        }
        String token = jwtServices.gerarToken(user);
        return new TokenDTO(token);
    }
}
