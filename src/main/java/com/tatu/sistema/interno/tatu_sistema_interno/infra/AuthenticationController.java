package com.tatu.sistema.interno.tatu_sistema_interno.infra;

import com.tatu.sistema.interno.tatu_sistema_interno.infra.security.TokenService;
import com.tatu.sistema.interno.tatu_sistema_interno.user.Users;
import com.tatu.sistema.interno.tatu_sistema_interno.user.UsersRepository;

import jakarta.validation.Valid;

import lombok.experimental.var;

import br.com.safeguard.check.SafeguardCheck;
import br.com.safeguard.types.ParametroTipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Users) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {

        SafeguardCheck check = new SafeguardCheck();

        boolean hasError = check.elementOf(data.phone(), ParametroTipo.NUMERO).validate().hasError();

        if (usersRepository.existsByPhone(data.phone())){
            return ResponseEntity.badRequest().build();
        }

        if (hasError) {
            return ResponseEntity.badRequest().build();
        }

        else {
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            Users newUsers = new Users(data.login(), data.phone(), encryptedPassword);
            this.usersRepository.save(newUsers);
            return ResponseEntity.ok().build();
        }
    }

}
