package com.example.omtask.Contracts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractStatusRepository extends JpaRepository<ContractStatus, Long> {
    ContractStatus findByStatus(String status);
}
