package org.mapper.memory.service;

import org.mapper.memory.dto.UserDTO;
import org.mapper.memory.entity.User;
import org.mapper.memory.repository.UserRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class LoginService {
    private UserRepo userRepo;

    public LoginService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Mono<User> createUser(UserDTO userDTO) {

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setUserId(userDTO.getUserId());

        return Mono.just(user)
                .flatMap(userRepo::save);
    }

    public Mono<Boolean> isLoginSuccess(UserDTO userDTO) {
        return userRepo.findById(userDTO.getEmail())
                .filter(t -> t.getPassword().equals(userDTO.getPassword()))
                .map(t -> true)
                .switchIfEmpty(Mono.just(false));

    }


}
