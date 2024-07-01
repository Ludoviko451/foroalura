package com.laqf.foroalura.domain.models;

import jakarta.persistence.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;

@Table(name = "publicaciones")
@Entity(name = "publicacion")
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String autor = obtenerAutorDeLaSesion();
    private String titulo;
    private String contenido;
    private LocalDate fecha = LocalDate.now();

    public Publicacion() {
    }
    public Publicacion(PublicacionDTO publicacionDTO) {

        this.titulo = publicacionDTO.titulo();
        this.contenido = publicacionDTO.contenido();
    }

    public Long getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String obtenerAutorDeLaSesion() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName(); // Devuelve el nombre de usuario
        }
        return null; // O maneja de otra manera si no hay usuario autenticado
    }
}
