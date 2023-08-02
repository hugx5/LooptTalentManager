package io.github.hugx5.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SelectiveProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;

    // Relacionamento One-to-Many entre SelectiveProcess e Candidato
    @OneToMany
    @Column(name = "id_Selectiveprocess")
    private List<Candidato> candidatos;
}
