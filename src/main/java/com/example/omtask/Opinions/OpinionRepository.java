package com.example.omtask.Opinions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepository
         extends JpaRepository<Opinion, Long> {
        Opinion findOpinionById(Long Id);
}
