package com.example.omtask.Controllers;

import com.example.omtask.Instances.Instance;
import com.example.omtask.Instances.InstanceService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class InstanceController {

    private final InstanceService instanceService;

    @PostMapping()
    public ResponseEntity<Instance>CreateInstance(@RequestBody Instance instance){
        return ResponseEntity.ok(instanceService.AddNewInstance(instance));
    }
}
