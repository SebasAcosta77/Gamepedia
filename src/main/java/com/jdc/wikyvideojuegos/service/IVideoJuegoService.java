package com.jdc.wikyvideojuegos.service;

import com.jdc.wikyvideojuegos.DTO.VideoJuegoDTO;
import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;

import java.util.List;

public interface IVideoJuegoService {
    public VideoJuegoEntity save(VideoJuegoDTO videojuegoDTO);
    public List<VideoJuegoEntity> findAll();
    public VideoJuegoEntity findById(Long id);

    public VideoJuegoEntity update(Long id , VideoJuegoDTO videojuegoDTO);
    public void deleteById(Long id);
}
