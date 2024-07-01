package com.laqf.foroalura.servicios;

import com.laqf.foroalura.domain.models.Publicacion;
import com.laqf.foroalura.domain.models.PublicacionDTO;
import com.laqf.foroalura.domain.models.PublicacionResponseDto;
import com.laqf.foroalura.repositorios.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PublicacionService implements IPublicacionService {

    @Autowired
    PublicacionRepository publicacionRepository;

    @Override
    public Publicacion savePublicacion(PublicacionDTO publicacionDTO) {
        Publicacion publicacion = new Publicacion(publicacionDTO);
        publicacionRepository.save(publicacion);

        return publicacion;
    }

    public Page<PublicacionResponseDto> getAll(Pageable pageable) {
        return publicacionRepository.findAll(pageable).map(PublicacionResponseDto::new);
    }
}
