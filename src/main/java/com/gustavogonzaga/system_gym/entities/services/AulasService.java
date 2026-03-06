package com.gustavogonzaga.system_gym.entities.services;

import com.gustavogonzaga.system_gym.dto.AulaDTO;
import com.gustavogonzaga.system_gym.entities.Agendamento;
import com.gustavogonzaga.system_gym.entities.Aulas;
import com.gustavogonzaga.system_gym.exceptions.ErroException;
import com.gustavogonzaga.system_gym.repository.AgendamentoRepository;
import com.gustavogonzaga.system_gym.repository.AulaRepository;
import org.springframework.stereotype.Service;

@Service
public class AulasService {
    private final AulaRepository aulaRepository;
    private final AgendamentoRepository agendamentoRepository;

    public AulasService(AulaRepository aulaRepository, AgendamentoRepository agendamentoRepository) {
        this.aulaRepository = aulaRepository;
        this.agendamentoRepository = agendamentoRepository;
    }
    public AulaDTO buscarPorId(Long id){
      Aulas aula = aulaRepository.findById(id).orElseThrow(() -> new ErroException("Aula não Encontrada"));
      return new AulaDTO(aula.getId(), aula.getAulas(), aula.getFuncional());
    }

    public AulaDTO criar(Long agendamentoId,AulaDTO dto){
        Agendamento agendamento = agendamentoRepository.findById(agendamentoId).orElseThrow(() -> new ErroException("Agendamento Não Encontrado "));
        Aulas aula = new Aulas();
        aula.setAulas(dto.getAulas());
        aula.setFuncional(dto.getFuncional());
        aula.setAgendamento(agendamento);

        Aulas salva = aulaRepository.save(aula);

        return new AulaDTO(salva.getId(), salva.getAulas(), salva.getFuncional());
    }
}
