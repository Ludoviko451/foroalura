package com.laqf.foroalura.domain.models;

import java.time.LocalDate;

public record PublicacionResponseDto(
        Long id,
        String autor,
        String titulo,
        String contenido,
        LocalDate fecha
) {

    public PublicacionResponseDto(Publicacion publicacion) {

        this(publicacion.getId(), publicacion.getAutor(), publicacion.getTitulo(), publicacion.getContenido(), publicacion.getFecha());
    }

}
