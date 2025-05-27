package com.jdc.wikyvideojuegos.service.Implements;

import com.jdc.wikyvideojuegos.DTO.DatoCuriosoDTO;
import com.jdc.wikyvideojuegos.Entities.DatoCuriosoEntity;
import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;
import com.jdc.wikyvideojuegos.repository.DatoCuriosoRepository;
import com.jdc.wikyvideojuegos.repository.VideoJuegoRepository;
import com.jdc.wikyvideojuegos.service.IDatoCuriosoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DatoCuriosoServiceImplement implements IDatoCuriosoService {
    @Autowired
    private DatoCuriosoRepository datocuriosorepository;
    //busca el id de videojuego
    @Autowired
    private VideoJuegoRepository videojuegorepository;


    @Override
    public DatoCuriosoEntity save(DatoCuriosoDTO datocuriosoDTO) {
        DatoCuriosoEntity datocuriosoSave = new DatoCuriosoEntity();

        // Obtener el médico desde el repositorio
        VideoJuegoEntity fkVideojuego = videojuegorepository.findById(datocuriosoDTO.getVideoJuego()).orElse(null);

        // Validar que el médico no sea null antes de asignarlo
        if (fkVideojuego == null) {
            throw new IllegalArgumentException("El ID del médico no es válido.");
        }

        datocuriosoSave.setDescripcion(datocuriosoDTO.getDescripcion());

        // Asignar correctamente el dato obtenido
        datocuriosoSave.setVideoJuego(fkVideojuego);

        return datocuriosorepository.save(datocuriosoSave);
    }

    @Override
    public List<DatoCuriosoEntity> findAll() {
        return datocuriosorepository.findAll();
    }

    @Override
    public DatoCuriosoEntity findById(Long id) {
        return datocuriosorepository.findById(id).orElse(null);
    }

    @Override
    public DatoCuriosoEntity update(Long id, DatoCuriosoDTO datocuriosoDTO) {
        DatoCuriosoEntity datoExistente = datocuriosorepository.findById(id).orElse(null);

        if (datoExistente == null) {
            return null; // O lanzar una excepción personalizada
        }

        // Actualizar solo los campos modificables
        datoExistente.setDescripcion(datocuriosoDTO.getDescripcion());

        //guardamos los datos actualizados de la cita
        return datocuriosorepository.save(datoExistente);
    }

    @Override
    public void deleteById(Long id) {
        datocuriosorepository.deleteById(id);

    }
}
