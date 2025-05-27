package com.jdc.wikyvideojuegos.service;

import com.jdc.wikyvideojuegos.DTO.ComentarioDTO;
import com.jdc.wikyvideojuegos.Entities.ComentarioEntity;

import java.util.List;

public interface IComnetarioService {
    public ComentarioEntity save(ComentarioDTO comentarioDTO);
    public List<ComentarioEntity> findAll();
    public ComentarioEntity findById(Long id);

    public ComentarioEntity update(Long id , ComentarioDTO comentarioDTO);
    public void deleteById(Long id);
}
