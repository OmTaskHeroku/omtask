package com.example.omtask.Controllers;

import com.example.omtask.Instances.InstanceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class InstanceController {

    private final InstanceService instanceService;
}
