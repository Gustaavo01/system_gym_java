package com.gustavogonzaga.system_gym.controller;

import com.gustavogonzaga.system_gym.dto.AgendamentoDTO;
import com.gustavogonzaga.system_gym.dto.UserDTO;
import com.gustavogonzaga.system_gym.entities.User;
import com.gustavogonzaga.system_gym.entities.services.AgendamentoService;
import com.gustavogonzaga.system_gym.entities.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    private AgendamentoService agendamentoService;

    private UserService userService;

    public UsuarioController(UserService userService,AgendamentoService agendamentoService){
        this.agendamentoService =agendamentoService;
        this.userService = userService;
    }
    @PostMapping("/{id}/agendamentos")
    public AgendamentoDTO criarAgendamento(
            @PathVariable Long id,
            @RequestBody AgendamentoDTO dto
    ){
        return agendamentoService.criarParaUsuario(id, dto);
    }

    @PostMapping
    public UserDTO criar(@Valid @RequestBody UserDTO user){
        return userService.criar(user);
    }

    @GetMapping
    public Page<UserDTO> listar(Pageable pageable){
        return (Page<UserDTO>) userService.listar(pageable);
    }

    @GetMapping("/{id}/agendamentos")
    public List<AgendamentoDTO> listarAgendamentos(@PathVariable Long id){
        return userService.listarAgendamentos(id);
    }

    @GetMapping("/{id}")
    public UserDTO buscar(@PathVariable Long id){
        return userService.BuscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        userService.deletar(id);
    }
}