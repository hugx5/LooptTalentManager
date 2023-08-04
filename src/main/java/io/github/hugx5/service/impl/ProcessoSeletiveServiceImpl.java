package io.github.hugx5.service.impl;

import io.github.hugx5.entity.Candidato;
import io.github.hugx5.entity.SelectiveProcess;
import io.github.hugx5.repository.CandidatoRepository;
import io.github.hugx5.repository.SelectiveProcessRepository;
import io.github.hugx5.service.ProcessoSeletiveService;
import io.github.hugx5.utils.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProcessoSeletiveServiceImpl implements ProcessoSeletiveService {


    private final SelectiveProcessRepository selectiveProcessRepository;
    private final CandidatoRepository candidatoRepository;

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
    public void criarCandidato(UUID id, Candidato candidato) { //Cria um candidato
        Optional<SelectiveProcess> selectiveProcessOptional = selectiveProcessRepository.findById(id); //Busca o processo seletivo pelo id
        if (selectiveProcessOptional.isPresent()) { //Se o processo seletivo existir
            SelectiveProcess selectiveProcess = selectiveProcessOptional.get(); //Busca o processo seletivo pelo id
            candidato.setStatus(Status.PENDENTE); //Seta o status do candidato como pendente
            candidato.setSelectiveProcess(selectiveProcess); //Seta o processo seletivo para o candidato
            candidatoRepository.save(candidato); //Salva o candidato
        }
    }

    @Override
    public List<Candidato> buscarCandidatosPorProcessoSeletivo(UUID id, Integer quantidade) {
        Optional<SelectiveProcess> selectiveProcessOptional = selectiveProcessRepository.findById(id);
        if (selectiveProcessOptional.isPresent()) { //Se o processo seletivo existir
            List<Candidato> candidatos = candidatoRepository.findByStatusNotAndSelectiveProcessId(Status.APROVADO, id); //Busca os candidatos pelo id do processo seletivo
            Collections.shuffle(candidatos); //Embaralha a lista de candidatos
            return candidatos.stream().limit(quantidade).collect(Collectors.toList()); //Retorna os 5 primeiros candidatos da lista
        }
        return Collections.emptyList(); //Retorna uma lista vazia
    }

    @Override
    public void atualizarStatusCandidato(UUID id, Status status) {
        Optional<Candidato> candidatoOptional = candidatoRepository.findById(id);
        if (candidatoOptional.isPresent()) {
            Candidato candidato = candidatoOptional.get();
            candidato.setStatus(status);
            candidatoRepository.save(candidato);
        }
    }

    @Override
    public List<Candidato> buscarTodosCandidatosPorProcessoSeletivo(UUID id) {
        Optional<SelectiveProcess> selectiveProcessOptional = selectiveProcessRepository.findById(id);
        if (selectiveProcessOptional.isPresent()) { //Se o processo seletivo existir
            List<Candidato> candidatos = candidatoRepository.findBySelectiveProcessId(id); //Busca os candidatos pelo id do processo seletivo
            return candidatos; //Retorna todos os candidatos
        }
        return Collections.emptyList(); //Retorna uma lista vazia se o processo seletivo não existir
    }


}



