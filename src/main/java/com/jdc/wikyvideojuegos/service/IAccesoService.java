package com.jdc.wikyvideojuegos.service;

import com.jdc.wikyvideojuegos.DTO.AccesoDTO;
import com.jdc.wikyvideojuegos.Entities.AccesoEntity;

import java.util.List;

public interface IAccesoService {
    public AccesoEntity save(AccesoDTO accesoDTO);
    public List<AccesoEntity> findAll();
    public AccesoEntity findById(Long id);
    public AccesoEntity update(Long id , AccesoDTO accesoDTO);
    public void deleteById(Long id);
}
