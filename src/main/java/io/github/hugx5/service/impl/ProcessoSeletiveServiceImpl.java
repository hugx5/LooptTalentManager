package io.github.hugx5.service.impl;

import io.github.hugx5.entity.Candidato;
import io.github.hugx5.entity.SelectiveProcess;
import io.github.hugx5.repository.CandidatoRepository;
import io.github.hugx5.repository.SelectiveProcessRepository;
import io.github.hugx5.service.ProcessoSeletiveService;
import io.github.hugx5.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ProcessoSeletiveServiceImpl implements ProcessoSeletiveService {

    private final SelectiveProcessRepository selectiveProcessRepository;
    private final CandidatoRepository candidatoRepository;

    @Autowired
    public ProcessoSeletiveServiceImpl(SelectiveProcessRepository selectiveProcessRepository,
                                       CandidatoRepository candidatoRepository) {
        this.selectiveProcessRepository = selectiveProcessRepository;
        this.candidatoRepository = candidatoRepository;
    }

    @Override
    public SelectiveProcess salvar(SelectiveProcess selectiveProcess) {
        return selectiveProcessRepository.save(selectiveProcess);
    }

    @Override
    public List<SelectiveProcess> listaSelectiveProcess() {
        return selectiveProcessRepository.findAll();
    }

    @Override
    public Optional<SelectiveProcess> buscarPorId(UUID id) {
        return selectiveProcessRepository.findById(id);
    }

    @Override
    public void removerPorId(UUID id) {
        selectiveProcessRepository.deleteById(id);
    }

    @Override
    public List<Candidato> buscarCandidatosPorIdDoProcesso(UUID id) {
        Optional<SelectiveProcess> selectiveProcessOptional = selectiveProcessRepository.findById(id);
        if (selectiveProcessOptional.isPresent()) {
            SelectiveProcess selectiveProcess = selectiveProcessOptional.get();
            return selectiveProcess.getCandidatos();
        }
        return null;
    }
    @Override
    public void criarCandidato(UUID id, Candidato candidato) {
        Optional<SelectiveProcess> selectiveProcessOptional = selectiveProcessRepository.findById(id);
        if (selectiveProcessOptional.isPresent()) {
            SelectiveProcess selectiveProcess = selectiveProcessOptional.get();
            candidato.setStatus(Status.PENDENTE);
            candidato.setSelectiveProcess(selectiveProcess);
            candidatoRepository.save(candidato);
        }
    }
}

