package dev.carlos.api_viagens.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.carlos.api_viagens.entities.dto.response.ClimaMasterResponse;
import dev.carlos.api_viagens.service.ClimaService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "destino")
public class Destino {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;
    private String cep;
    private String localidade;
    private String estado;
    @Transient
    private ClimaMasterResponse climaMasterResponse;
    @JsonIgnore
    @OneToMany(mappedBy = "destino")
    private Set<Viagem> viagens = new HashSet<>();

    public String getCep(){
        return cep.replace("-", "");
    }


}
