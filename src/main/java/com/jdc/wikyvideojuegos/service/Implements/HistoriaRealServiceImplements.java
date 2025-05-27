package com.jdc.wikyvideojuegos.service.Implements;

import com.jdc.wikyvideojuegos.DTO.HistoriaRealDTO;
import com.jdc.wikyvideojuegos.Entities.HistoriaRealEntity;
import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;
import com.jdc.wikyvideojuegos.repository.HistoriaRealRepository;
import com.jdc.wikyvideojuegos.repository.VideoJuegoRepository;
import com.jdc.wikyvideojuegos.service.IHistoriaRealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HistoriaRealServiceImplements implements IHistoriaRealService {
    @Autowired
    private HistoriaRealRepository historiarealrepository;
    //busca el id de videojuego
    @Autowired
    private VideoJuegoRepository videojuegorepository;


    @Override
    public HistoriaRealEntity save(HistoriaRealDTO historiarealDTO) {
        HistoriaRealEntity historiasave = new HistoriaRealEntity();

        // Obtener el videojuego desde el repositorio
        VideoJuegoEntity fkVideojuego = videojuegorepository.findById(historiarealDTO.getVideojuego()).orElse(null);

        // Validar que el médico no sea null antes de asignarlo
        if (fkVideojuego == null) {
            throw new IllegalArgumentException("El ID del videojuego  no es válido.");
        }

        historiasave.setDescripcion(historiarealDTO.getDescripcion());
        historiasave.setEventosimportantes(historiarealDTO.getEventosimportantes());
        // Asignar correctamente el videojuego obtenido
        historiasave.setVideoJuego(fkVideojuego);

        return historiarealrepository.save(historiasave);
    }

    @Override
    public List<HistoriaRealEntity> findAll() {
        return historiarealrepository.findAll();
    }

    @Override
    public HistoriaRealEntity findById(Long id) {
        return historiarealrepository.findById(id).orElse(null);
    }

    @Override
    public HistoriaRealEntity update(Long id, HistoriaRealDTO historiarealDTO) {
        HistoriaRealEntity historiaExistente = historiarealrepository.findById(id).orElse(null);

        if (historiaExistente == null) {
            return null; // O lanzar una excepción personalizada
        }

        // Actualizar solo los campos modificables
        historiaExistente.setDescripcion(historiarealDTO.getDescripcion());
        historiaExistente.setEventosimportantes(historiarealDTO.getEventosimportantes());

        //guardamos los datos actualizados de comic
        return historiarealrepository.save(historiaExistente);
    }

    @Override
    public void deleteById(Long id) {
        historiarealrepository.deleteById(id);
    }
}
