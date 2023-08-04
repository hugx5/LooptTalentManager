package io.github.hugx5.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import io.github.hugx5.utils.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Gera o id automaticamente
    private UUID id; //UUID é um tipo de id que gera um id aleatório
    private String nome;
    private String foto;

    @Enumerated(EnumType.STRING) //Salva o enum como string no banco de dados
    private Status status;


    @JsonBackReference //Evita recursividade infinita
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //Muitos candidatos para um processo seletivo
    @JoinColumn(name = "id_Selective_process") //Nome da coluna que vai ser criada na tabela candidato
    private SelectiveProcess selectiveProcess; //Nome do atributo que vai ser criado na tabela candidato

}