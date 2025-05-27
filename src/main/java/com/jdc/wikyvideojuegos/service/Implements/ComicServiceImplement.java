package com.jdc.wikyvideojuegos.service.Implements;

import com.jdc.wikyvideojuegos.DTO.ComicDTO;
import com.jdc.wikyvideojuegos.Entities.ComicEntity;
import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;
import com.jdc.wikyvideojuegos.repository.ComicRepository;
import com.jdc.wikyvideojuegos.repository.VideoJuegoRepository;
import com.jdc.wikyvideojuegos.service.IComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComicServiceImplement implements IComicService {
    @Autowired
    private ComicRepository comicrepository;
    //busca el id de videojuego
    @Autowired
    private VideoJuegoRepository videojuegorepository;


    @Override
    public ComicEntity save(ComicDTO comicDTO) {
        ComicEntity comicSave = new ComicEntity();

        // Obtener el médico desde el repositorio
        VideoJuegoEntity fkVideojuego = videojuegorepository.findById(comicDTO.getVideojuego()).orElse(null);

        // Validar que el médico no sea null antes de asignarlo
        if (fkVideojuego == null) {
            throw new IllegalArgumentException("El ID del médico no es válido.");
        }

        comicSave.setTitulo(comicDTO.getTitulo());
        comicSave.setResumen(comicDTO.getResumen());
        comicSave.setFechapublicacion(comicDTO.getFechapublicacion());
        comicSave.setUrlimagen(comicSave.getUrlimagen());
        // Asignar correctamente el videojuego obtenido
        comicSave.setVideojuego(fkVideojuego);

        return comicrepository.save(comicSave);
    }

    @Override
    public List<ComicEntity> findAll() {
        return comicrepository.findAll();
    }

    @Override
    public ComicEntity findById(Long id) {
        return comicrepository.findById(id).orElse(null);
    }

    @Override
    public ComicEntity update(Long id, ComicDTO comicDTO) {
        ComicEntity comicExistente = comicrepository.findById(id).orElse(null);

        if (comicExistente == null) {
            return null; // O lanzar una excepción personalizada
        }

        // Actualizar solo los campos modificables
        comicExistente.setTitulo(comicDTO.getTitulo());
        comicExistente.setResumen(comicDTO.getResumen());
        comicExistente.setFechapublicacion(comicDTO.getFechapublicacion());
        comicExistente.setUrlimagen(comicDTO.getUrlimagen());
        //guardamos los datos actualizados de comic
        return comicrepository.save(comicExistente);
    }

    @Override
    public void deleteById(Long id) {
        comicrepository.deleteById(id);

    }
}
