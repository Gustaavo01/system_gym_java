package com.gustavogonzaga.system_gym.entities.services;

import com.gustavogonzaga.system_gym.dto.AgendamentoDTO;
import com.gustavogonzaga.system_gym.dto.UserDTO;
import com.gustavogonzaga.system_gym.entities.User;
import com.gustavogonzaga.system_gym.exceptions.ErroException;
import com.gustavogonzaga.system_gym.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDTO criar(UserDTO userDTO){
        User user = new User();
        user.setNome(userDTO.getNome());
        User salvo = userRepository.save(user);
        return new UserDTO(salvo.getId(),salvo.getNome());
    }

    public UserDTO BuscarPorId(Long id){
      User user = userRepository.findById(id).orElseThrow(() -> new ErroException("Usuario Não Encontrado"));
      return new UserDTO(user.getId(), user.getNome());
    }

    public Page<UserDTO> listar(Pageable pageable){
        return userRepository.findAll(pageable)
                .map(user -> new UserDTO(user.getId(), user.getNome()));
    }
    public void deletar(Long id){
         userRepository.deleteById(id);
    }

    public List<AgendamentoDTO> listarAgendamentos(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new ErroException("Usuario não encontrado"));
        return user.getAgendamentos().stream().map(a -> new AgendamentoDTO(a.getId(), a.getData())).toList();
    }

}
