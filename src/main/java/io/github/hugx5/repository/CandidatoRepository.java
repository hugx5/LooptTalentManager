package io.github.hugx5.repository;

import io.github.hugx5.entity.Candidato;
import io.github.hugx5.utils.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, UUID> {

    List<Candidato> findByStatusNotAndSelectiveProcessId(Status status, UUID id);
    List<Candidato> findBySelectiveProcessId(UUID selectiveProcessId);

}
