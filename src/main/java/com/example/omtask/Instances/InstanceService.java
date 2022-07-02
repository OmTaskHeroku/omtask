package com.example.omtask.Instances;

import com.example.omtask.Users.UserService;
import lombok.AllArgsConstructor;import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InstanceService {

    private final InstanceRepository instanceRepository;
    private final TrustRepository trustRepository;

    public void addTrustTOInstance(String trustName, String instanceAddress){
        Instance instance = instanceRepository.findByAddress(instanceAddress);
        instance.setTrust(trustRepository.findByName(trustName));
        instanceRepository.save(instance);
    }

    public void save(Instance instance){
        instanceRepository.save(instance);
    }

    public Instance getOriginInstance(){
        Instance instance = instanceRepository.findByAddress("origin");
        if(instance == null){
            instance = new Instance();
            instance.setAddress("origin");
        }
        return instance;
    }
    public Instance AddNewInstance(Instance instance){
        instance.setName(instance.getName());
        instance.setAddress(instance.getAddress());
        instanceRepository.save(instance);
        String trustName = "Origin";
        String instanceAddress = instance.getAddress();
        addTrustTOInstance(trustName, instanceAddress);
        return instance;
    }
}
