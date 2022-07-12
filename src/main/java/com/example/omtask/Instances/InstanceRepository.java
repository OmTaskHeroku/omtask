package com.example.omtask.Instances;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstanceRepository
         extends JpaRepository<Instance, Long> {
    Instance findByAddress(String address);
    List<Instance> findAllByTrust(Trust trust);
}
