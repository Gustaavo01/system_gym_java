package com.gustavogonzaga.system_gym.entities.services;


import com.gustavogonzaga.system_gym.dto.AgendamentoDTO;
import com.gustavogonzaga.system_gym.entities.Agendamento;
import com.gustavogonzaga.system_gym.entities.User;
import com.gustavogonzaga.system_gym.exceptions.ErroException;
import com.gustavogonzaga.system_gym.repository.AgendamentoRepository;
import com.gustavogonzaga.system_gym.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;
    private final UserRepository userRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, UserRepository userRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.userRepository = userRepository;
    }

    public AgendamentoDTO criar(Long userId,AgendamentoDTO dto){
        Agendamento agendamento = new Agendamento();
        agendamento.setData(dto.getData());
        Agendamento salvo = agendamentoRepository.save(agendamento);
        return new AgendamentoDTO(salvo.getId(), salvo.getData());
    }
    public AgendamentoDTO buscarPorId(Long id){
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow(() -> new ErroException("Agendamento Não Encontrado"));
        return new AgendamentoDTO(agendamento.getId(), agendamento.getData());
    }

    public List<AgendamentoDTO> listar(){
        return agendamentoRepository.findAll().stream().map(a -> new AgendamentoDTO(a.getId(), a.getData())).toList();
    }

    public AgendamentoDTO atualizar(Long id, AgendamentoDTO dto){

        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new ErroException("Agendamento não encontrado"));

        agendamento.setData(dto.getData());

        Agendamento atualizado = agendamentoRepository.save(agendamento);

        return new AgendamentoDTO(
                atualizado.getId(),
                atualizado.getData()
        );
    }
    public AgendamentoDTO criarParaUsuario(Long userId, AgendamentoDTO dto){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Agendamento agendamento = new Agendamento();
        agendamento.setData(dto.getData());
        agendamento.setUser(user);

        agendamentoRepository.save(agendamento);

        return new AgendamentoDTO(
                agendamento.getId(),
                agendamento.getData()
        );
    }
    public void delete(Long id){
        agendamentoRepository.deleteById(id);
    }
}
