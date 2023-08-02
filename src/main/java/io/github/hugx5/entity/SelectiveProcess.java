package io.github.hugx5.entity;

import io.github.hugx5.entity.Candidato;
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
    private UUID id;

    private String nome;

    // Relacionamento One-to-Many entre SelectiveProcess e Candidato
    @OneToMany(mappedBy = "selectiveProcess", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Candidato> candidatos;

    // Outros atributos e métodos da entidade...
}
