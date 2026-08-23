package dev.carlos.api_viagens.service;

import dev.carlos.api_viagens.entities.Destino;
import dev.carlos.api_viagens.entities.dto.request.CoordenadaRequest;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Locale;

@Service
public class CoordenadaService {

    public final String coordendas = "https://nominatim.openstreetmap.org/search?addressdetails=1&q=%s+%s&format=jsonv2&limit=1";

    public List<CoordenadaRequest> buscarCoordenadas(Destino destino) throws IOException, InterruptedException {
        HttpClient client1 = HttpClient.newHttpClient();
        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(URI.create(urlCoordenadas(destino.getLocalidade().replace(" ", ""), destino.getEstado().replace(" ", ""))))
                .build();
        ObjectMapper mapper = new ObjectMapper();
        HttpResponse<String> response1 = client1.send(request1, HttpResponse.BodyHandlers.ofString());
        return (mapper.readValue(response1.body(), new TypeReference<List<CoordenadaRequest>>() {}));
    }

    public String urlCoordenadas(String cidade, String estado){
        return String.format(Locale.US, coordendas, cidade.replace(" ", ""), estado.replace(" ", ""));
    }
}
