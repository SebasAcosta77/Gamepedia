package com.jdc.wikyvideojuegos.service.Implements;

import com.jdc.wikyvideojuegos.DTO.LoreDTO;
import com.jdc.wikyvideojuegos.Entities.DatoCuriosoEntity;
import com.jdc.wikyvideojuegos.Entities.LoreEntity;
import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;
import com.jdc.wikyvideojuegos.repository.LoreRepository;
import com.jdc.wikyvideojuegos.repository.VideoJuegoRepository;
import com.jdc.wikyvideojuegos.service.ILoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoreServiceImplements implements ILoreService {
    @Autowired
    private LoreRepository lorerepository;
    //busca el id de videojuego
    @Autowired
    private VideoJuegoRepository videojuegorepository;

    @Override
    public LoreEntity save(LoreDTO loreDTO) {
        LoreEntity loresave = new LoreEntity();

        // Obtener el videojuego desde el repositorio
        VideoJuegoEntity fkVideojuego = videojuegorepository.findById(loreDTO.getVideojuego()).orElse(null);

        // Validar que el médico no sea null antes de asignarlo
        if (fkVideojuego == null) {
            throw new IllegalArgumentException("El ID del videojuego  no es válido.");
        }

        loresave.setDescripcion(loreDTO.getDescripcion());
        loresave.setLineatiempo(loreDTO.getLineatiempo());
        // Asignar correctamente el videojuego obtenido
        loresave.setVideoJuego(fkVideojuego);

        return lorerepository.save(loresave);
    }

    @Override
    public List<LoreEntity> findAll() {
        return lorerepository.findAll();
    }

    @Override
    public LoreEntity findById(Long id) {
        return lorerepository.findById(id).orElse(null);
    }

    @Override
    public LoreEntity update(Long id, LoreDTO loreDTO) {
        LoreEntity loreExistente = lorerepository.findById(id).orElse(null);

        if (loreDTO == null) {
            return null; // O lanzar una excepción personalizada
        }

        // Actualizar solo los campos modificables
        loreExistente.setDescripcion(loreDTO.getDescripcion());
        loreExistente.setLineatiempo(loreDTO.getLineatiempo());

        //guardamos los datos actualizados de la cita
        return lorerepository.save(loreExistente);
    }

    @Override
    public void deleteById(Long id) {
        lorerepository.deleteById(id);

    }
}
