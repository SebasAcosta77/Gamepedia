package com.jdc.wikyvideojuegos.service;

import com.jdc.wikyvideojuegos.DTO.EmpresaDTO;
import com.jdc.wikyvideojuegos.Entities.EmpresaEntity;

import java.util.List;

public interface IEmpresaService {
    public EmpresaEntity save(EmpresaDTO empresaDTO);
    public List<EmpresaEntity> findAll();
    public EmpresaEntity findById(Long id);

    public EmpresaEntity update(Long id , EmpresaDTO empresaDTO);
    public void deleteById(Long id);
}
