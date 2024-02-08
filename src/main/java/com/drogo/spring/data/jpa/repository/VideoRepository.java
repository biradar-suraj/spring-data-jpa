package com.drogo.spring.data.jpa.repository;

import com.drogo.spring.data.jpa.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}
