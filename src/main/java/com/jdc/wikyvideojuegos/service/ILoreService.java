package com.jdc.wikyvideojuegos.service;

import com.jdc.wikyvideojuegos.DTO.LoreDTO;
import com.jdc.wikyvideojuegos.Entities.LoreEntity;

import java.util.List;

public interface ILoreService {
    public LoreEntity save(LoreDTO loreDTO);
    public List<LoreEntity> findAll();
    public LoreEntity findById(Long id);

    public LoreEntity update(Long id , LoreDTO loreDTO);
    public void deleteById(Long id);
}
