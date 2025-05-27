package com.jdc.wikyvideojuegos.service.Implements;

import com.jdc.wikyvideojuegos.DTO.ValoracionDTO;
import com.jdc.wikyvideojuegos.Entities.RolEntity;
import com.jdc.wikyvideojuegos.Entities.UsuarioEntity;
import com.jdc.wikyvideojuegos.Entities.ValoracionEntity;
import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;
import com.jdc.wikyvideojuegos.repository.RolRepository;
import com.jdc.wikyvideojuegos.repository.UsuarioRepository;
import com.jdc.wikyvideojuegos.repository.ValoracionRepository;
import com.jdc.wikyvideojuegos.repository.VideoJuegoRepository;
import com.jdc.wikyvideojuegos.service.IValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ValoracionServiceImplements implements IValoracionService {
    @Autowired
    private ValoracionRepository valoracionrepository;
    //busca el id de usuario
    @Autowired
    private UsuarioRepository usuariorepository;
    //busca el id de videojuego
    @Autowired
    private VideoJuegoRepository videojuegorepository;

    @Override
    public ValoracionEntity save(ValoracionDTO valoracionDTO) {
        ValoracionEntity valoracionsave = new ValoracionEntity();

        // Obtener el usuario desde el repositorio
        UsuarioEntity fkUsuario = usuariorepository.findById(valoracionDTO.getUsuario()).orElse(null);
        // Obtener el videojuego desde el repositorio
        VideoJuegoEntity fkVideojuego = videojuegorepository.findById(valoracionDTO.getVideojuego()).orElse(null);

        // Validar que el rol no sea null antes de asignarlo
        if (fkUsuario == null || fkVideojuego == null) {
            throw new IllegalArgumentException("El ID del usuario o videojuego  no es válido.");
        }

        valoracionsave.setPuntuacion(valoracionDTO.getPuntuacion());
        valoracionsave.setComentario(valoracionDTO.getComentario());
        // Asignar correctamente el usuario y videojuego obtenido
        valoracionsave.setUsuario(fkUsuario);
        valoracionsave.setVideoJuego(fkVideojuego);

        return valoracionrepository.save(valoracionsave);
    }

    @Override
    public List<ValoracionEntity> findAll() {
        return valoracionrepository.findAll();
    }

    @Override
    public ValoracionEntity findById(Long id) {
        return valoracionrepository.findById(id).orElse(null);
    }

    @Override
    public ValoracionEntity update(Long id, ValoracionDTO valoracionDTO) {
        ValoracionEntity valoracionExistente = valoracionrepository.findById(id).orElse(null);

        if (valoracionExistente == null) {
            return null; // O lanzar una excepción personalizada
        }

        // Actualizar solo los campos modificables
        valoracionExistente.setPuntuacion(valoracionDTO.getPuntuacion());
        valoracionExistente.setComentario(valoracionDTO.getComentario());

        //guardamos los datos actualizados de valoracion
        return valoracionrepository.save(valoracionExistente);
    }

    @Override
    public void deleteById(Long id) {
        valoracionrepository.deleteById(id);

    }
}
