package io.github.hugx5.controller;

import io.github.hugx5.entity.Candidato;
import io.github.hugx5.entity.SelectiveProcess;
import io.github.hugx5.repository.SelectiveProcessRepository;
import io.github.hugx5.service.ProcessoSeletiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/processosseletivos")
public class ProcessoSeletivoController {

    private final SelectiveProcessRepository processoSeletivoRepository;
    private final ProcessoSeletiveService processoSeletiveService;


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

    // Endpoint para obter candidatos de um processo seletivo pelo ID do processo
    @GetMapping("/{id}/candidatos")
    @ResponseStatus(HttpStatus.OK)
    public List<Candidato> obterCandidatosPorProcessoSeletivo(@PathVariable UUID id) {
        return processoSeletiveService.buscarCandidatosPorIdDoProcesso(id);
    }

    @PostMapping("/{id}/candidatos")
    @ResponseStatus(HttpStatus.CREATED)
    public void criarCandidato(@PathVariable("id") UUID id,@RequestBody Candidato candidato) {
        processoSeletiveService.criarCandidato(id,candidato);
    }

   }
