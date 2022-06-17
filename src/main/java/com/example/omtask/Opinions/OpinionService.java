package com.example.omtask.Opinions;

import com.example.omtask.Contracts.Contract;
import com.example.omtask.Contracts.ContractStatus;
import com.example.omtask.Instances.Instance;
import com.example.omtask.Users.User;
import com.example.omtask.Users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OpinionService {

    private final OpinionRepository opinionRepository;

    public Opinion addNewOpinion(Opinion opinion){
        opinion.setContent(opinion.getContent());
        opinion.setRate(opinion.getRate());
        Contract contract= opinion.getContract();
        opinion.setContract(contract);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        User judge = UserService.getUserByUsername(username);
        return opinion;
    }

    public Opinion getOpinion(Long Id){
        Opinion opinion = opinionRepository.findOpinionById(Id);
        if(opinion == null) throw new IllegalArgumentException("No comment");
        return opinion;
    }
    public Opinion ShowAllOpinion(Contract contract){
        List<Opinion> opinion = opinionRepository.findAllByContract(contract);
        if (opinion == null) throw new IllegalArgumentException("Can't find any comment");
        return (Opinion) opinion;
    }
}
