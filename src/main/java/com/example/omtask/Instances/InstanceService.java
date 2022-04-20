package com.example.omtask.Instances;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InstanceService {

    private final InstanceRepository instanceRepository;
}
