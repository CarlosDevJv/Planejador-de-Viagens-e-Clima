package dev.carlos.api_viagens.entities.dto.response;

import java.util.ArrayList;

public record ClimaDailyResponse(ArrayList<Float> temperature_2m_min, ArrayList<Float> temperature_2m_max, ArrayList<Float> wind_speed_10m_max) {
}
