package com.jdc.wikyvideojuegos.service;

import com.jdc.wikyvideojuegos.DTO.UsuarioDTO;
import com.jdc.wikyvideojuegos.Entities.UsuarioEntity;

import java.util.List;

public interface IUsuarioService {
    public UsuarioEntity save(UsuarioDTO usuarioDTO);
    public List<UsuarioEntity> findAll();
    public UsuarioEntity findById(Long id);

    public UsuarioEntity update(Long id , UsuarioDTO usuarioDTO);
    public void deleteById(Long id);
}
