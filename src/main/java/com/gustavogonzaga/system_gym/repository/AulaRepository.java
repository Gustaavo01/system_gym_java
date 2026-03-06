package com.gustavogonzaga.system_gym.repository;

import com.gustavogonzaga.system_gym.entities.Aulas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<Aulas,Long> {
}
