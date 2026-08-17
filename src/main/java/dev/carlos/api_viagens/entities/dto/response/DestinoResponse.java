package dev.carlos.api_viagens.entities.dto.response;

public record DestinoResponse(String cep, String logradouro, String bairro, String localidade, String uf,
                              double temperaturaAtual, double temperaturaMax, double temperaturaMin,
                              String condicao, int velocidadeVento, int umidade) {
}
