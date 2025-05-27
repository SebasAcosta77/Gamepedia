package com.jdc.wikyvideojuegos.repository;

import com.jdc.wikyvideojuegos.Entities.NoticiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<NoticiaEntity, Long> {
}
