package com.jdc.wikyvideojuegos.service;

import com.jdc.wikyvideojuegos.DTO.RolDTO;
import com.jdc.wikyvideojuegos.Entities.RolEntity;

import java.util.List;

public interface IRolService {
    public RolEntity save(RolDTO rolDTO);
    public List<RolEntity> findAll();
    public RolEntity findById(Long id);

    public RolEntity update(Long id , RolDTO rolDTO);
    public void deleteById(Long id);
}
