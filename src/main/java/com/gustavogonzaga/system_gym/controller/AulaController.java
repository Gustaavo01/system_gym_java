package com.gustavogonzaga.system_gym.controller;

import com.gustavogonzaga.system_gym.dto.AulaDTO;
import com.gustavogonzaga.system_gym.entities.Aulas;
import com.gustavogonzaga.system_gym.entities.services.AulasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamentos/{agendamentoId}/aulas")
public class AulaController {
    @Autowired AulasService aulasService;
    public AulaController(AulasService aulasService){
        this.aulasService = aulasService;
    }
    @PostMapping
    public AulaDTO criar(@PathVariable Long agendamentoId, @RequestBody AulaDTO dto){
        return aulasService.criar(agendamentoId,dto);
    }
}
