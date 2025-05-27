package com.jdc.wikyvideojuegos.repository;

import com.jdc.wikyvideojuegos.Entities.ComicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicRepository extends JpaRepository<ComicEntity, Long> {
}
