package com.example.omtask.Opinions;

import com.example.omtask.Contracts.Contract;
import com.example.omtask.Instances.Instance;
import com.example.omtask.Users.User;
import com.example.omtask.Users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class OpinionService {

    private final OpinionRepository opinionRepository;
    private final UserService userService;

    public Opinion addNewOpinion(Opinion opinion){
        opinion.setContent(opinion.getContent());
        opinion.setRate(opinion.getRate());
        opinion.setContract(opinion.getContract());
        User suspect = opinion.getSuspect();
        opinion.setSuspect(suspect);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        User judge = userService.getUserByUsername(username);
        if (Objects.equals(judge.getId(), suspect.getId())) throw new IllegalArgumentException("Judge and Suspect can't be the same");
        opinion.setJudge(judge);
        opinionRepository.save(opinion);
        return opinion;
    }

    public Opinion getOpinion(Long Id){
        Opinion opinion = opinionRepository.findOpinionById(Id);
        if(opinion == null) throw new IllegalArgumentException("No comment");
        return opinion;
    }

    public List<Opinion> ShowAllOpinion(){
        return opinionRepository.findAll();
    }

    public List<Opinion> ShowOpinionsForOneUser(String suspects_nick){
        User suspect = userService.getUserByUsername(suspects_nick);
        List<Opinion> opinion = opinionRepository.findAllBySuspect(suspect);
        if (opinion == null) throw new IllegalArgumentException("Can't find any comment");
        return opinion;
    }
}
