package dev.carlos.api_viagens.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "tb_users")
public class User {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;
    private String nome;
    private String email;
    private LocalDateTime dataCadastro;

//    @OneToMany(mappedBy = "contratante")
//    private Set<Viagem> viagens = new HashSet<>();


}
