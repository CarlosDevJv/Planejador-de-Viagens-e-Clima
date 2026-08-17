package dev.carlos.api_viagens.entities.dto.response;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ClimaMasterResponse {
    @Transient
    private ClimaDailyResponse daily;
    @Transient
    private ClimaCurrentResponse current;


    @Override
    public String toString() {
        return "ClimaInfo{" +
                ", temperature_2m=" + current.temperature_2m() +
                ", temperature_2m_max=" + daily.temperature_2m_max() +
                ", temperature_2m_min=" + daily.temperature_2m_min() +
                ", wind_speed_10m_max=" + daily.wind_speed_10m_max();
    }
}
