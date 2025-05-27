package com.jdc.wikyvideojuegos.repository;

import com.jdc.wikyvideojuegos.Entities.ComentarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<ComentarioEntity, Long> {
}
