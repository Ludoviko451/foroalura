package com.laqf.foroalura.controller;

import com.laqf.foroalura.domain.models.LoginDTo;
import com.laqf.foroalura.domain.models.Usuario;
import com.laqf.foroalura.security.DatosJWTToken;
import com.laqf.foroalura.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid LoginDTo loginDto){
        Authentication token = new UsernamePasswordAuthenticationToken(loginDto.username(), loginDto.password());
        authenticationManager.authenticate(token);
        var usuarioAutenticado = authenticationManager.authenticate(token);
        var jwt = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(jwt));

    }


}
