package dev.carlos.api_viagens.entities.dto.response;

public record ClimaResponse(String temperature_2m, String time, String temperature_2m_min, String temperature_2m_max, String wind_speed_10m_max, String relative_humidity_2m) {
}
