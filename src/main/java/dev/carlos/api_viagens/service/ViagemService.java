package dev.carlos.api_viagens.service;
import dev.carlos.api_viagens.entities.User;
import dev.carlos.api_viagens.entities.Viagem;
import dev.carlos.api_viagens.entities.dto.request.CriarViagemRequest;
import dev.carlos.api_viagens.entities.dto.response.ClimaMasterResponse;
import dev.carlos.api_viagens.entities.Destino;
import dev.carlos.api_viagens.entities.dto.request.CriarDestinoRequest;
import dev.carlos.api_viagens.repositories.UserRepository;
import dev.carlos.api_viagens.repositories.ViagemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import static java.util.Locale.setDefault;

@Service
public class ViagemService {
    @Autowired
    DestinoService destinoService;
    @Autowired
    ViagemRepository viagemRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ClimaService climaService;

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");



    public Viagem buscarLocal(CriarViagemRequest criarViagemRequest) throws Exception {
        try {
            User user = userRepository.findByEmail(criarViagemRequest.email()).orElseThrow(() -> new EntityNotFoundException("Usuário Não Econtrado"));
            Viagem viagem = new Viagem();
            viagem.setDescricao(criarViagemRequest.descricao());
            viagem.setTitulo(criarViagemRequest.titulo());
            viagem.setDataFim(LocalDate.parse(criarViagemRequest.dataFim(), dateTimeFormatter));
            viagem.setDataInicio(LocalDate.parse(criarViagemRequest.dataInicio(), dateTimeFormatter));
            viagem.setDestino(definirDestino(criarViagemRequest.cep()));
            return viagem;



        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    public Destino definirDestino(String cep) throws IOException, InterruptedException {
        Destino destino = destinoService.buscarDestino(cep);
        destino.setClimaMasterResponse(climaService.buscarClima(cep));
        return destino;
    }



}
