package com.example.omtask.Contracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository
         extends JpaRepository<Contract, Long> {
    List<Contract> findAllByStatusIsNot(ContractStatus contractStatus);
}
