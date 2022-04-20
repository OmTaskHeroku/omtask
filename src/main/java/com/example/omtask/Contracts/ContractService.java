package com.example.omtask.Contracts;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;
}
