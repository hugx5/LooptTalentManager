package io.github.hugx5.controller;

import io.github.hugx5.entity.Candidato;
import io.github.hugx5.service.CandidatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/candidatos")
public class CandidatosController {

    private final CandidatoService candidatoService;



}
