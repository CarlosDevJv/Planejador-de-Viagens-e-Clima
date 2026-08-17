package dev.carlos.api_viagens.service;

import dev.carlos.api_viagens.entities.Destino;
import dev.carlos.api_viagens.entities.dto.request.CriarDestinoRequest;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class DestinoService {
    public final String viaCep = "http://viacep.com.br/ws/";


    public Destino buscarDestino(String cep) throws IOException, InterruptedException {
        String urlRequest = viaCep + cep + "/json";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlRequest))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), Destino.class);
    }
}
