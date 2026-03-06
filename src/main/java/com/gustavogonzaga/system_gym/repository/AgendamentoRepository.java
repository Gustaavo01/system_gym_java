package com.gustavogonzaga.system_gym.repository;

import com.gustavogonzaga.system_gym.entities.Agendamento;
import com.gustavogonzaga.system_gym.entities.Aulas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
    static void delete(Long agendamento) {

    }
}
