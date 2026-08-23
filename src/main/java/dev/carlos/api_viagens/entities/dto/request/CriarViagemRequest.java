package dev.carlos.api_viagens.entities.dto.request;

import java.time.LocalDate;

public record CriarViagemRequest(String email, String cep, String titulo, String descricao, String dataInicio, String dataFim) {
}
