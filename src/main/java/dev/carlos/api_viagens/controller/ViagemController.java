package dev.carlos.api_viagens.controller;

import dev.carlos.api_viagens.entities.dto.request.CriarDestinoRequest;
import dev.carlos.api_viagens.entities.dto.request.CriarViagemRequest;
import dev.carlos.api_viagens.service.ClimaService;
import dev.carlos.api_viagens.service.ViagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/viagem")
public class ViagemController {

    @Autowired
    ViagemService viagemService;
    @Autowired
    ClimaService climaService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarViagem(@RequestBody CriarViagemRequest criarViagemRequest ) throws Exception {
        return ResponseEntity.ok().body(viagemService.buscarLocal(criarViagemRequest));
    }

    @GetMapping("/clima/{cep}")
    public ResponseEntity<?> buscarClima(@PathVariable String cep) throws Exception{
        return ResponseEntity.ok().body(climaService.buscarClima(cep));
    }
}
