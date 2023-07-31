package io.github.hugx5.Controller;

import io.github.hugx5.entity.ProcessoSeletivo;
import io.github.hugx5.repository.ProcessoSeletivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processosseletivos")
public class ProcessoSeletivoController {
    @Autowired
    private ProcessoSeletivoRepository processoSeletivoRepository;

    @GetMapping
    public List<ProcessoSeletivo> obterProcessosSeletivos() {
        return processoSeletivoRepository.findAll();
    }
    @GetMapping("/{id}/entrar")
    public ResponseEntity<Void> Redirecionar(@PathVariable Long id) {
        // Se o processo estiver aberto, você pode redirecionar o usuário para a página de inscrição:
        return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/LPT-002?id=" + id).build();

    }
    @PostMapping
    public ProcessoSeletivo cadastrarProcessoSeletivo(@RequestBody ProcessoSeletivo novoProcesso) {
        return processoSeletivoRepository.save(novoProcesso);
    }
}
