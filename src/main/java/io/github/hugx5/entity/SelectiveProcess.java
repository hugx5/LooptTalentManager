package io.github.hugx5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "selective_process")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SelectiveProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; //Recomendado para arquitetura de microservicos para evitar duplicidades
    private String nome;


    @OneToMany(mappedBy = "selectiveProcess", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Candidato> candidatos;


}
