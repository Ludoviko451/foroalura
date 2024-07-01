package com.laqf.foroalura.servicios;

import com.laqf.foroalura.domain.models.Publicacion;
import com.laqf.foroalura.domain.models.PublicacionDTO;
import com.laqf.foroalura.domain.models.PublicacionResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IPublicacionService {

    Publicacion savePublicacion(PublicacionDTO publicacionDTO);

    Page<PublicacionResponseDto> getAll(Pageable pageable);
}
