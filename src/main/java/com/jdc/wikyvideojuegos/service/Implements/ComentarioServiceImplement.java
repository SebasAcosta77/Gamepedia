package com.jdc.wikyvideojuegos.service.Implements;

import com.jdc.wikyvideojuegos.DTO.ComentarioDTO;
import com.jdc.wikyvideojuegos.DTO.UsuarioDTO;
import com.jdc.wikyvideojuegos.Entities.ComentarioEntity;
import com.jdc.wikyvideojuegos.Entities.UsuarioEntity;
import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;
import com.jdc.wikyvideojuegos.repository.ComentarioRepository;
import com.jdc.wikyvideojuegos.repository.UsuarioRepository;
import com.jdc.wikyvideojuegos.repository.VideoJuegoRepository;
import com.jdc.wikyvideojuegos.service.IComnetarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComentarioServiceImplement implements IComnetarioService {
    @Autowired
    private ComentarioRepository comentarioepository;
    //busca el id de usuario
    @Autowired
    private UsuarioRepository usuariorepository;

    @Autowired
    private VideoJuegoRepository videoJuegorepository;

    @Override
    public ComentarioEntity save(ComentarioDTO comentarioDTO) {
        ComentarioEntity comentrioSave = new ComentarioEntity();

        // Obtener el usuario desde el repositorio
        UsuarioEntity fkUsuario = usuariorepository.findById(comentarioDTO.getUsuario()).orElse(null);
        // Obtener el videojuego desde el repositorio
        VideoJuegoEntity fkVideojuego = videoJuegorepository.findById(comentarioDTO.getVideojuego()).orElse(null);

        // Validar que el médico no sea null antes de asignarlo
        if (fkUsuario == null && fkVideojuego == null) {
            throw new IllegalArgumentException("El ID del médico no es válido.");
        }

        comentrioSave.setContenido(comentarioDTO.getContenido());
        comentrioSave.setFechacomentario(comentarioDTO.getFechacomentario());
        // Asignar correctamente el usuario obtenido
        comentrioSave.setUsuario(fkUsuario);
        // Asignar correctamente el videojuego obtenido
        comentrioSave.setVideojuego(fkVideojuego);

        return comentarioepository.save(comentrioSave);
    }

    @Override
    public List<ComentarioEntity> findAll() {
        return comentarioepository.findAll();
    }

    @Override
    public ComentarioEntity findById(Long id) {
        return comentarioepository.findById(id).orElse(null);
    }

    @Override
    public ComentarioEntity update(Long id, ComentarioDTO comentarioDTO) {
        ComentarioEntity comentarioExistente = comentarioepository.findById(id).orElse(null);

        if (comentarioExistente == null) {
            return null; // O lanzar una excepción personalizada
        }

        // Actualizar solo los campos modificables
        comentarioExistente.setContenido(comentarioDTO.getContenido());
        comentarioExistente.setFechacomentario(comentarioDTO.getFechacomentario());

        //guardamos los datos actualizados de comentario
        return comentarioepository.save(comentarioExistente);
    }

    @Override
    public void deleteById(Long id) {
        comentarioepository.deleteById(id);

    }
}
