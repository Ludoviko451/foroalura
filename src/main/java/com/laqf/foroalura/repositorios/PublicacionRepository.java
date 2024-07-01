package com.laqf.foroalura.repositorios;

import com.laqf.foroalura.domain.models.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
}
