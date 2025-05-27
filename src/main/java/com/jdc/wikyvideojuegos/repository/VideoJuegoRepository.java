package com.jdc.wikyvideojuegos.repository;

import com.jdc.wikyvideojuegos.Entities.VideoJuegoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoJuegoRepository extends JpaRepository<VideoJuegoEntity, Long> {
}
