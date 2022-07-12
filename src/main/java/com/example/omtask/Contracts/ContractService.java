package com.example.omtask.Contracts;

import com.example.omtask.Instances.Instance;
import com.example.omtask.Instances.InstanceRepository;
import com.example.omtask.Users.User;
import com.example.omtask.Users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContractService {

    private final ContractRepository contractRepository;
    private final ContractStatusRepository contractStatusRepository;
    private final InstanceRepository instanceRepository;
    private final UserService userService;

    public List<Contract> showContractsByStatusNotOf(ContractStatus contractStatus) {
        List<Contract> contract = contractRepository.findAllByStatusIsNot(contractStatus);
        if (contract == null) throw new IllegalArgumentException("Can't find any contract");
        return contract;
    }

    public Contract getContract(Long Id){
        Contract contract = contractRepository.findContractById(Id);
        if(contract == null) throw new IllegalArgumentException("Can't find contract");
        return contract;
    }

    public ContractStatus findByStatusName(String status) {
        ContractStatus contractStatus = contractStatusRepository.findByStatus(status);
        if (contractStatus == null) throw new IllegalArgumentException("Can't find any matching contract status");
        return contractStatus;
    }

//    public Contract saveContract(Contract contract) {
//        return contractRepository.save(contract);
//    }

    public Contract addNewContract(Contract contract) {
        contract.setTitle(contract.getTitle());
        contract.setDescription(contract.getDescription());
        contract.setPrice(contract.getPrice());
        contract.setStatus(findByStatusName("active"));
        contract.setExpiration_date(contract.getExpiration_date());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        User user = userService.getUserByUsername(username);
        Instance origin = user.getOrigin();
        contract.setCreator(origin);
        String address = "origin";
        contract.setContractor(instanceRepository.findByAddress(address));
        contractRepository.save(contract);
        return contract;
    }
}
