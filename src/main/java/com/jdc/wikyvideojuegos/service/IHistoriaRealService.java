package com.jdc.wikyvideojuegos.service;

import com.jdc.wikyvideojuegos.DTO.HistoriaRealDTO;
import com.jdc.wikyvideojuegos.Entities.HistoriaRealEntity;

import java.util.List;

public interface IHistoriaRealService {
    public HistoriaRealEntity save(HistoriaRealDTO historiarealDTO);
    public List<HistoriaRealEntity> findAll();
    public HistoriaRealEntity findById(Long id);

    public HistoriaRealEntity update(Long id , HistoriaRealDTO historiarealDTO);
    public void deleteById(Long id);
}
