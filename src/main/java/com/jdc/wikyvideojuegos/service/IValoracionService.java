package com.jdc.wikyvideojuegos.service;

import com.jdc.wikyvideojuegos.DTO.ValoracionDTO;
import com.jdc.wikyvideojuegos.Entities.ValoracionEntity;

import java.util.List;

public interface IValoracionService {
    public ValoracionEntity save(ValoracionDTO valoracionDTO);
    public List<ValoracionEntity> findAll();
    public ValoracionEntity findById(Long id);

    public ValoracionEntity update(Long id , ValoracionDTO valoracionDTO);
    public void deleteById(Long id);
}
