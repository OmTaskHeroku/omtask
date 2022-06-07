package com.example.omtask.Controllers;

import com.example.omtask.Contracts.Contract;
import com.example.omtask.Contracts.ContractService;
import com.example.omtask.Contracts.ContractStatus;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/contracts")
public class ContractController {

    private final ContractService contractService;

    @GetMapping("/list")
    public ResponseEntity<?> showAllContracts() {
        ContractStatus contractStatus = contractService.findByStatusName("not_active");
        return ResponseEntity.ok().body(contractService.showContractsByStatusNotOf(contractStatus));
    }

    @PostMapping("/new")
    public ResponseEntity<Contract> createContract(@RequestBody Contract contract){  //Valid?
        return ResponseEntity.ok(contractService.addNewContract(contract));
    }

}
