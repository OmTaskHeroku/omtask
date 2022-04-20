package com.example.omtask.Controllers;

import com.example.omtask.Contracts.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ContractController {

    private final ContractService contractService;
}
