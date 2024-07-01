package com.laqf.foroalura.repositorios;

import com.laqf.foroalura.domain.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByLogin(String login);
}
