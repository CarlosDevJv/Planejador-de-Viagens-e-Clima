package dev.carlos.api_viagens.repositories;

import dev.carlos.api_viagens.entities.Destino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DestinoRepository extends JpaRepository<Destino, String> {
    Destino findByCep(String cep);
}
