package dev.carlos.api_viagens.controller;

import dev.carlos.api_viagens.entities.dto.request.CriarUserRequest;
import dev.carlos.api_viagens.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/criarUsuario")
    public ResponseEntity<?> criarUsuario(@RequestBody CriarUserRequest userRequest){
            userService.criarUsuario(userRequest);
            return ResponseEntity.ok().build();

    }
}
