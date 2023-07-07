package bstorm.bibliothequeapi.controllers;

import bstorm.bibliothequeapi.models.dto.UserLoginDTO;
import bstorm.bibliothequeapi.models.dto.UserRegistrationDTO;
import bstorm.bibliothequeapi.models.dto.UserTokenDTO;
import bstorm.bibliothequeapi.models.entities.securities.User;
import bstorm.bibliothequeapi.services.securities.UserService;
import bstorm.bibliothequeapi.utils.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class AuthenticationController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthenticationController(UserService userService, JwtUtil jwtUtil) {

        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/api/register")
    public ResponseEntity<UserTokenDTO> register(@Valid @RequestBody UserRegistrationDTO dto){

        User user = userService.register(dto.toEntity());
        String token = jwtUtil.generateToken(user);
        return ResponseEntity.ok(UserTokenDTO.fromEntity(user, token));
    }

    @PostMapping("/api/login")
    public ResponseEntity<UserTokenDTO> login(@Valid @RequestBody UserLoginDTO dto){

        User user = userService.login(dto.toEntity());
        String token = jwtUtil.generateToken(user);
        return ResponseEntity.ok(UserTokenDTO.fromEntity(user,token));


    }

}
