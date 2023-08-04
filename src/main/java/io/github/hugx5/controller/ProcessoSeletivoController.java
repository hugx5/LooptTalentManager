package io.github.hugx5.controller;

import io.github.hugx5.entity.Candidato;
import io.github.hugx5.entity.SelectiveProcess;
import io.github.hugx5.service.CandidatoService;
import io.github.hugx5.service.ProcessoSeletiveService;
import io.github.hugx5.utils.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/processosseletivos")
public class ProcessoSeletivoController {

    private final ProcessoSeletiveService processoSeletiveService;
    private final CandidatoService candidatoService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SelectiveProcess> obterProcessosSeletivos() {
        return processoSeletiveService.listaSelectiveProcess();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SelectiveProcess cadastrarProcessoSeletivo(@RequestBody SelectiveProcess novoProcesso) {
        return processoSeletiveService.salvar(novoProcesso);
    }

    @PostMapping("/{id}/candidatos")
    @ResponseStatus(HttpStatus.CREATED)
    public void criarCandidato(@PathVariable("id") UUID id, @RequestBody Candidato candidato) {
        processoSeletiveService.criarCandidato(id, candidato);
    }


    @GetMapping("/{id}/candidatos")
    @ResponseStatus(HttpStatus.OK)
    public List<Candidato> buscarCandidatoPorProcessoSeletivo(@PathVariable("id") UUID id, @RequestParam(value = "quantidade", defaultValue = "5") Integer quantidade) {
        return processoSeletiveService.buscarCandidatosPorProcessoSeletivo(id, quantidade);
    }

    @PutMapping("candidatos/{id}/status/{status}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarStatusCandidato(@PathVariable("id") UUID id, @PathVariable("status") Status status) { //Atualiza o status do candidato
        processoSeletiveService.atualizarStatusCandidato(id, status); //Chama o método atualizarStatusCandidato do service
    }

    @GetMapping("candidatos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Candidato buscarCandidatoPorId(@PathVariable("id") UUID id) {
        return candidatoService.buscarCandidatoPorId(id);
    }

    @GetMapping("/{id}/todosCandidatos")
    @ResponseStatus(HttpStatus.OK)
    public List<Candidato> buscarTodosCandidatosPorProcessoSeletivo(@PathVariable("id") UUID id) {
        return processoSeletiveService.buscarTodosCandidatosPorProcessoSeletivo(id);
    }

}


