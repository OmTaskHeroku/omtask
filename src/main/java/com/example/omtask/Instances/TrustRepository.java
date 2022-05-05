package com.example.omtask.Instances;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrustRepository extends JpaRepository<Trust, Long> {

    Trust findByName(String name);
}
