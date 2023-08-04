package io.github.hugx5.service;

import io.github.hugx5.entity.Candidato;
import io.github.hugx5.entity.SelectiveProcess;
import io.github.hugx5.utils.Status;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProcessoSeletiveService {

    SelectiveProcess salvar(SelectiveProcess selectiveProcess);

    List<SelectiveProcess> listaSelectiveProcess();

    Optional<SelectiveProcess> buscarPorId(UUID id);

    void removerPorId(UUID id);

    void criarCandidato(UUID id, Candidato candidato);

    List<Candidato> buscarCandidatosPorProcessoSeletivo(UUID id, Integer quantidade);

    void atualizarStatusCandidato(UUID id, Status status);
}
