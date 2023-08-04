package io.github.hugx5.service;

import io.github.hugx5.entity.Candidato;

import java.util.UUID;

public interface CandidatoService {

    Candidato buscarCandidatoPorId(UUID id);

}
