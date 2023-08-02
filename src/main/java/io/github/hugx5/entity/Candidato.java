package io.github.hugx5.entity;


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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String foto;
    private String status;
}
