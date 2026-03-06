package com.gustavogonzaga.system_gym.controller;

import com.gustavogonzaga.system_gym.dto.AgendamentoDTO;
import com.gustavogonzaga.system_gym.entities.Agendamento;
import com.gustavogonzaga.system_gym.entities.User;
import com.gustavogonzaga.system_gym.entities.services.AgendamentoService;
import com.gustavogonzaga.system_gym.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    @Autowired
    AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @GetMapping("/{id}")
    public AgendamentoDTO buscar(@PathVariable Long id){
        return agendamentoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public AgendamentoDTO atualizar(@PathVariable Long id, @RequestBody AgendamentoDTO dto){
        return agendamentoService.atualizar(id,dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        agendamentoService.delete(id);
    }
}
