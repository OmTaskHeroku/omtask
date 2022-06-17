package com.example.omtask.Opinions;

import com.example.omtask.Contracts.Contract;
import com.example.omtask.Contracts.ContractStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpinionRepository
         extends JpaRepository<Opinion, Long> {
        Opinion findOpinionById(Long Id);
        List<Opinion> findAllByContract(Contract contract);
}
