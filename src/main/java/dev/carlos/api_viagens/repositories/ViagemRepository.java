package dev.carlos.api_viagens.repositories;

import dev.carlos.api_viagens.entities.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViagemRepository extends JpaRepository<Viagem, String> {
}
