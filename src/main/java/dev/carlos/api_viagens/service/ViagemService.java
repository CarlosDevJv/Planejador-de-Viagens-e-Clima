package dev.carlos.api_viagens.service;
import dev.carlos.api_viagens.entities.dto.request.CriarViagemRequest;
import dev.carlos.api_viagens.entities.dto.response.ClimaMasterResponse;
import dev.carlos.api_viagens.entities.Destino;
import dev.carlos.api_viagens.entities.dto.request.CriarDestinoRequest;
import dev.carlos.api_viagens.repositories.UserRepository;
import dev.carlos.api_viagens.repositories.ViagemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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




    public void buscarLocal(CriarViagemRequest criarViagemRequest) throws Exception {

        userRepository.findByEmail(criarViagemRequest.email()).orElseThrow(() -> new EntityNotFoundException("Usuário Não Econtrado"));


        Destino destino = destinoService.buscarDestino(criarViagemRequest.cep());
        climaService.buscarClima(criarViagemRequest.cep());

    }




}
