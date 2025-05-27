package com.jdc.wikyvideojuegos.service.Implements;

import com.jdc.wikyvideojuegos.DTO.NoticiaDTO;
import com.jdc.wikyvideojuegos.Entities.NoticiaEntity;
import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;
import com.jdc.wikyvideojuegos.repository.NoticiaRepository;
import com.jdc.wikyvideojuegos.repository.VideoJuegoRepository;
import com.jdc.wikyvideojuegos.service.INoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoticiaServiceImplemets implements INoticiaService {
    @Autowired
    private NoticiaRepository noticiarepository;
    //busca el id de videojuego
    @Autowired
    private VideoJuegoRepository videojuegorepository;


    @Override
    public NoticiaEntity save(NoticiaDTO noticiaDTO) {
        NoticiaEntity noticiasave = new NoticiaEntity();

        // Obtener el videojuego desde el repositorio
        VideoJuegoEntity fkVideojuego = videojuegorepository.findById(noticiaDTO.getVideojuego()).orElse(null);

        // Validar que el médico no sea null antes de asignarlo
        if (fkVideojuego == null) {
            throw new IllegalArgumentException("El ID del videojuego  no es válido.");
        }

        noticiasave.setTitulo(noticiaDTO.getTitulo());
        noticiasave.setContenido(noticiaDTO.getContenido());
        noticiasave.setFechapublicacion(noticiaDTO.getFechapublicacion());
        noticiasave.setFuente(noticiaDTO.getFuente());
        // Asignar correctamente el videojuego obtenido
        noticiasave.setVideoJuego(fkVideojuego);

        return noticiarepository.save(noticiasave);
    }

    @Override
    public List<NoticiaEntity> findAll() {
        return noticiarepository.findAll();
    }

    @Override
    public NoticiaEntity findById(Long id) {
        return noticiarepository.findById(id).orElse(null);
    }

    @Override
    public NoticiaEntity update(Long id, NoticiaDTO noticiaDTO) {
        NoticiaEntity noticiaExistente = noticiarepository.findById(id).orElse(null);

        if (noticiaExistente == null) {
            return null; // O lanzar una excepción personalizada
        }

        // Actualizar solo los campos modificables
        noticiaExistente.setTitulo(noticiaDTO.getTitulo());
        noticiaExistente.setContenido(noticiaDTO.getContenido());
        noticiaExistente.setFechapublicacion(noticiaDTO.getFechapublicacion());
        noticiaExistente.setFuente(noticiaDTO.getFuente());

        //guardamos los datos actualizados de comic
        return noticiarepository.save(noticiaExistente);

    }

    @Override
    public void deleteById(Long id) {
        noticiarepository.deleteById(id);

    }
}
