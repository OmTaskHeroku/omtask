package com.example.omtask.Contracts;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;
    private final ContractStatusRepository contractStatusRepository;

    public List<Contract> showContractsByStatusNotOf(ContractStatus contractStatus) {
        List<Contract> contract = contractRepository.findAllByStatusIsNot(contractStatus);
        if(contract == null) throw new IllegalArgumentException("Can't find any contract");
        return contract;
    }

    public ContractStatus findByStatusName(String status){
        ContractStatus contractStatus = contractStatusRepository.findByStatus(status);
        if(contractStatus == null) throw new IllegalArgumentException("Can't find any contract");
        return contractStatus;
    }
}
