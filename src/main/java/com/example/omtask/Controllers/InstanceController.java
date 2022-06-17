package com.example.omtask.Controllers;

import com.example.omtask.Contracts.Contract;
import com.example.omtask.Instances.Instance;
import com.example.omtask.Instances.InstanceRepository;
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
    private final InstanceRepository instanceRepository;

    @PostMapping()
    public ResponseEntity<Instance>CreateInstance(@RequestBody Instance instance){
        return ResponseEntity.ok(instanceService.AddNewInstance(instance));
    }
    @GetMapping("/instance")
    public Instance getOriginInstance(){
        Instance instance = instanceRepository.findByAddress("origin");
        if(instance == null){
            instance = new Instance();
            instance.setAddress("origin");
        }
        return instance;
    }
}
