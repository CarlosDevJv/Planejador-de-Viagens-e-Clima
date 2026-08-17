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
@Table(name = "tb_destino")
public class Destino {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;
    private String cep;
    private String localidade;
    private String estado;
    private String logradouro;
    private String bairro;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    @OneToMany(mappedBy = "destino")
    private Set<Viagem> viagens = new HashSet<>();

    @Override
    public String toString(){
        return getLocalidade() + getLogradouro() + getEstado() + getCep();
    }
}
