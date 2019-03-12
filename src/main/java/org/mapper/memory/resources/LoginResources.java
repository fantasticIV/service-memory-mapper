package org.mapper.memory.resources;

import org.mapper.memory.dto.UserDTO;
import org.mapper.memory.entity.User;
import org.mapper.memory.service.LoginService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class LoginResources {

    private LoginService loginService;

    public LoginResources(LoginService loginService) {
        this.loginService = loginService;
    }

    @PutMapping("/signup")
    public Mono<User> signUp(@RequestBody UserDTO userDTO) {
        return loginService.createUser(userDTO);

    }

    @GetMapping("/login")
    public Mono<Boolean> login(@RequestBody UserDTO userDTO) {
        return loginService.isLoginSuccess(userDTO);

    }

}
