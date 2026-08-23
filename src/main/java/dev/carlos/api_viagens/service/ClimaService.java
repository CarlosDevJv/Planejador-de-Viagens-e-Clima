package dev.carlos.api_viagens.service;

import dev.carlos.api_viagens.entities.dto.response.ClimaMasterResponse;
import dev.carlos.api_viagens.entities.Destino;
import dev.carlos.api_viagens.entities.dto.request.CoordenadaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Locale;

@Service
public class ClimaService {
    @Autowired
    CoordenadaService coordenadaService;
    @Autowired
    DestinoService destinoService;


    public final String clima = "https://api.open-meteo.com/v1/forecast?latitude=%f&longitude=%f&daily=temperature_2m_min,temperature_2m_max,wind_speed_10m_max&current=temperature_2m&timezone=auto&forecast_days=1";
    public ClimaMasterResponse buscarClima(String cep) throws IOException, InterruptedException {
        Destino destino = destinoService.buscarDestino(cep);
        List<CoordenadaRequest> coordenadas = coordenadaService.buscarCoordenadas(destino);


        HttpClient client2 = HttpClient.newHttpClient();
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(urlClima(coordenadas.getFirst().lat(), coordenadas.getFirst().lon())))
                .build();
        ObjectMapper mapper = new ObjectMapper();
        HttpResponse<String> response2 = client2.send(request2, HttpResponse.BodyHandlers.ofString());
        return mapper.readValue(response2.body(), ClimaMasterResponse.class);
    }

    public String urlClima(Float latitude, Float longitude){
        return String.format(Locale.US, clima, latitude, longitude);
    }
}
