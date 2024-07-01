package com.laqf.foroalura.controller;

import com.laqf.foroalura.domain.models.Publicacion;
import com.laqf.foroalura.domain.models.PublicacionDTO;
import com.laqf.foroalura.domain.models.PublicacionResponseDto;
import com.laqf.foroalura.servicios.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionController {

    PublicacionService publicacionService = new PublicacionService();

    @Autowired
    public PublicacionController(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @PostMapping
    public ResponseEntity savePublicacion(@RequestBody PublicacionDTO publicacionDTO) {

        Publicacion publicacion = publicacionService.savePublicacion(publicacionDTO);

        return ResponseEntity.ok().body(publicacion);
    }

    @GetMapping
    public Page<PublicacionResponseDto> getAll(@PageableDefault(size = 10) Pageable pageable) {

        return publicacionService.getAll(pageable);
    }


}
