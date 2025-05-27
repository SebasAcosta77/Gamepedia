package com.jdc.wikyvideojuegos.service;

import com.jdc.wikyvideojuegos.DTO.NoticiaDTO;
import com.jdc.wikyvideojuegos.Entities.NoticiaEntity;

import java.util.List;

public interface INoticiaService {
    public NoticiaEntity save(NoticiaDTO noticiaDTO);
    public List<NoticiaEntity> findAll();
    public NoticiaEntity findById(Long id);

    public NoticiaEntity update(Long id , NoticiaDTO noticiaDTO);
    public void deleteById(Long id);
}
