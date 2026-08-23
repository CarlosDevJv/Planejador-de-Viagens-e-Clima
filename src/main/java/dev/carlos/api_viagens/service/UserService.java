package dev.carlos.api_viagens.service;

import dev.carlos.api_viagens.entities.User;
import dev.carlos.api_viagens.entities.dto.request.CriarUserRequest;
import dev.carlos.api_viagens.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public void criarUsuario(CriarUserRequest userRequest){
        try {
            Optional<User> user = userRepository.findByEmail(userRequest.email());
            if (user.isEmpty()){
                User newUser = new User();
                newUser.setDataCadastro(LocalDateTime.now());
                newUser.setNome(userRequest.nome());
                newUser.setEmail(userRequest.email());
                userRepository.save(newUser);
            }
            else {
                throw new RuntimeException();}
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
