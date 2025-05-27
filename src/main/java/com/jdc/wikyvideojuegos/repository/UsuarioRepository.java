package com.jdc.wikyvideojuegos.repository;

import com.jdc.wikyvideojuegos.Entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
