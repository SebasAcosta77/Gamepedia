package com.jdc.wikyvideojuegos.service.Implements;

import com.jdc.wikyvideojuegos.DTO.VideoJuegoDTO;
import com.jdc.wikyvideojuegos.Entities.EmpresaEntity;
import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;
import com.jdc.wikyvideojuegos.repository.EmpresaRepository;
import com.jdc.wikyvideojuegos.repository.VideoJuegoRepository;
import com.jdc.wikyvideojuegos.service.IVideoJuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoJuegoServiceImplements implements IVideoJuegoService {
    @Autowired
    private VideoJuegoRepository videojuegorepository;
    //busca el id de usuario
    @Autowired
    private EmpresaRepository empresarepository;


    @Override
    public VideoJuegoEntity save(VideoJuegoDTO videojuegoDTO) {
        VideoJuegoEntity videojuegosave = new VideoJuegoEntity();

        // Obtener la empresa desde el repositorio
        EmpresaEntity fkEmpresa = empresarepository.findById(videojuegoDTO.getEmpresa()).orElse(null);

        // Validar que la empresa no sea null antes de asignarlo
        if (fkEmpresa == null) {
            throw new IllegalArgumentException("El ID del empresa  no es válido.");
        }

        videojuegosave.setTitulo(videojuegoDTO.getTitulo());
        videojuegosave.setDescripcion(videojuegoDTO.getDescripcion());
        videojuegosave.setFechalanzamiento(videojuegoDTO.getFechalanzamiento());
        videojuegosave.setCaratulaurl(videojuegoDTO.getCaratulaurl());
        videojuegosave.setPlataforma(videojuegoDTO.getPlataforma());
        videojuegosave.setGenero(videojuegoDTO.getGenero());
        // Asignar correctamente el videojuego obtenido
        videojuegosave.setEmpresa(fkEmpresa);

        return videojuegorepository.save(videojuegosave);
    }

    @Override
    public List<VideoJuegoEntity> findAll() {
        return videojuegorepository.findAll();
    }

    @Override
    public VideoJuegoEntity findById(Long id) {
        return videojuegorepository.findById(id).orElse(null);
    }

    @Override
    public VideoJuegoEntity update(Long id, VideoJuegoDTO videojuegoDTO) {
        VideoJuegoEntity videoExistente = videojuegorepository.findById(id).orElse(null);

        if (videoExistente == null) {
            return null; // O lanzar una excepción personalizada
        }

        // Actualizar solo los campos modificables
        videoExistente.setTitulo(videojuegoDTO.getTitulo());
        videoExistente.setDescripcion(videojuegoDTO.getDescripcion());
        videoExistente.setFechalanzamiento(videojuegoDTO.getFechalanzamiento());
        videoExistente.setCaratulaurl(videojuegoDTO.getCaratulaurl());
        videoExistente.setPlataforma(videojuegoDTO.getPlataforma());
        videoExistente.setGenero(videojuegoDTO.getGenero());

        //guardamos los datos actualizados de valoracion
        return videojuegorepository.save(videoExistente);
    }

    @Override
    public void deleteById(Long id) {
        videojuegorepository.deleteById(id);

    }
}
