package com.jdc.wikyvideojuegos.service;

import com.jdc.wikyvideojuegos.DTO.ComicDTO;
import com.jdc.wikyvideojuegos.Entities.ComicEntity;

import java.util.List;

public interface IComicService {
    public ComicEntity save(ComicDTO comicDTO);
    public List<ComicEntity> findAll();
    public ComicEntity findById(Long id);

    public ComicEntity update(Long id , ComicDTO comicDTO);
    public void deleteById(Long id);
}
