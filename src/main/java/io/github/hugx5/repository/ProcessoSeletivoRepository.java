package io.github.hugx5.repository;

import io.github.hugx5.entity.ProcessoSeletivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoSeletivoRepository extends JpaRepository<ProcessoSeletivo, Long> {

}
