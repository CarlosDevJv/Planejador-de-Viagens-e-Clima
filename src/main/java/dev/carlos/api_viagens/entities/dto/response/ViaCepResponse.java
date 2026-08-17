package dev.carlos.api_viagens.entities.dto.response;

public record ViaCepResponse(String cep, String logradouro, String bairro, String localidade, String uf) {
}
