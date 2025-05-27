package com.jdc.wikyvideojuegos.service.Implements;

import com.jdc.wikyvideojuegos.DTO.AccesoDTO;
import com.jdc.wikyvideojuegos.Entities.AccesoEntity;
import com.jdc.wikyvideojuegos.repository.AccesoRepository;
import com.jdc.wikyvideojuegos.service.IAccesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccesoServiceImplements implements IAccesoService {
    @Autowired
    private AccesoRepository accesorepository;

    @Override
    public AccesoEntity save(AccesoDTO accesoDTO) {
        AccesoEntity acceso = new AccesoEntity();

        acceso.setNombreacceso(accesoDTO.getNombreacceso());
        acceso.setClaveacceso(accesoDTO.getClaveacceso());

        return accesorepository.save(acceso);
    }

    @Override
    public List<AccesoEntity> findAll() {
        return accesorepository.findAll();
    }

    @Override
    public AccesoEntity findById(Long id) {
        return accesorepository.findById(id).orElse(null);
    }

    @Override
    public AccesoEntity update(Long id, AccesoDTO accesoDTO) {
        AccesoEntity accesoExistente = accesorepository.findById(id).orElse(null);

        if (accesoExistente == null) {
            return null; // O lanzar una excepción personalizada
        }

        // Actualizar solo los campos modificables
        accesoExistente.setNombreacceso(accesoDTO.getNombreacceso());
        accesoExistente.setClaveacceso(accesoDTO.getClaveacceso());


        //guardamos los datos actualizados de el acceso
        return accesorepository.save(accesoExistente);
    }

    @Override
    public void deleteById(Long id) {
        accesorepository.deleteById(id);

    }
}
