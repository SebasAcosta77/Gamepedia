package com.jdc.wikyvideojuegos.service;

import com.jdc.wikyvideojuegos.DTO.DatoCuriosoDTO;
import com.jdc.wikyvideojuegos.Entities.DatoCuriosoEntity;

import java.util.List;

public interface IDatoCuriosoService {
    public DatoCuriosoEntity save(DatoCuriosoDTO datocuriosoDTO);
    public List<DatoCuriosoEntity> findAll();
    public DatoCuriosoEntity findById(Long id);

    public DatoCuriosoEntity update(Long id , DatoCuriosoDTO datocuriosoDTO);
    public void deleteById(Long id);
}
