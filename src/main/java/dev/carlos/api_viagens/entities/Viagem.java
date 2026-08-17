package dev.carlos.api_viagens.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tb_viagem")
public class Viagem {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private String id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
//    @ManyToOne
//    @JoinColumn(name = "contratante")
//    private User contratante;
    @ManyToOne
    @JoinColumn(name = "destino")
    private Destino destino;

}
