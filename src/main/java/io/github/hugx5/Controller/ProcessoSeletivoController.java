package io.github.hugx5.Controller;

import io.github.hugx5.entity.Candidato;
import io.github.hugx5.entity.SelectiveProcess;
import io.github.hugx5.repository.SelectiveProcessRepository;
import io.github.hugx5.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/processosseletivos")
public class ProcessoSeletivoController {

    private final SelectiveProcessRepository processoSeletivoRepository;
    private final ProService proService;

    @Autowired
    public ProcessoSeletivoController(SelectiveProcessRepository processoSeletivoRepository,
                                      ProService proService) {
        this.processoSeletivoRepository = processoSeletivoRepository;
        this.proService = proService;
    }

    @GetMapping
    public List<SelectiveProcess> obterProcessosSeletivos() {
        return proService.listaSelectiveProcess();
    }

    @PostMapping
    public SelectiveProcess cadastrarProcessoSeletivo(@RequestBody SelectiveProcess novoProcesso) {
        return proService.salvar(novoProcesso);
    }

    // Endpoint para obter candidatos de um processo seletivo pelo ID do processo
    @GetMapping("/{id}/candidatos")
    public List<Candidato> obterCandidatosPorProcessoSeletivo(@PathVariable UUID id) {
        return proService.buscarCandidatosPorIdDoProcesso(id);
    }

    // Outros endpoints conforme necessário para atender ao escopo do projeto
    // (por exemplo, selecionar um candidato como escolhido, embaralhar candidatos, etc.)
}
