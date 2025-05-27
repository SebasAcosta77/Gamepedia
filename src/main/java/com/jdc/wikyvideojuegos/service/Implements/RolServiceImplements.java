package com.jdc.wikyvideojuegos.service.Implements;

import com.jdc.wikyvideojuegos.DTO.RolDTO;
import com.jdc.wikyvideojuegos.Entities.NoticiaEntity;
import com.jdc.wikyvideojuegos.Entities.RolEntity;
import com.jdc.wikyvideojuegos.repository.NoticiaRepository;
import com.jdc.wikyvideojuegos.repository.RolRepository;
import com.jdc.wikyvideojuegos.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RolServiceImplements implements IRolService {
    @Autowired
    private RolRepository rolrepository;

    @Override
    public RolEntity save(RolDTO rolDTO) {
        RolEntity rolsave = new RolEntity();

        rolsave.setNombrerol(rolDTO.getNombrerol());
        rolsave.setEstadorol(rolDTO.getEstadorol());

        return rolrepository.save(rolsave);


    }

    @Override
    public List<RolEntity> findAll() {
        return rolrepository.findAll();
    }

    @Override
    public RolEntity findById(Long id) {
        return rolrepository.findById(id).orElse(null);
    }

    @Override
    public RolEntity update(Long id, RolDTO rolDTO) {
        RolEntity rolExistente = rolrepository.findById(id).orElse(null);

        if (rolExistente == null) {
            return null; // O lanzar una excepción personalizada
        }

        // Actualizar solo los campos modificables
        rolExistente.setNombrerol(rolDTO.getNombrerol());
        rolExistente.setEstadorol(rolDTO.getEstadorol());
        ;

        //guardamos los datos actualizados de comic
        return rolrepository.save(rolExistente);
    }

    @Override
    public void deleteById(Long id) {
        rolrepository.deleteById(id);

    }
}
