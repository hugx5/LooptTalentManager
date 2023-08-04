package io.github.hugx5.service.impl;

import io.github.hugx5.entity.Candidato;
import io.github.hugx5.repository.CandidatoRepository;
import io.github.hugx5.service.CandidatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CandidatoServiceImpl implements CandidatoService {

    private final CandidatoRepository candidatoRepository;

    @Override
    public Candidato buscarCandidatoPorId(UUID id) { //Busca um candidato pelo id
        return candidatoRepository.findById(id) //Busca o candidato pelo id
                .orElseThrow(() -> new RuntimeException("Candidato não encontrado"));  //Se não encontrar, lança uma exceção

    }
}
