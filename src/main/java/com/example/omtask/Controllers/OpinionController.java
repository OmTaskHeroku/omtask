package com.example.omtask.Controllers;

import com.example.omtask.Contracts.Contract;
import com.example.omtask.Contracts.ContractStatus;
import com.example.omtask.Opinions.Opinion;
import com.example.omtask.Opinions.OpinionRepository;
import com.example.omtask.Opinions.OpinionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OpinionController {

    private final OpinionService opinionService;
    private final OpinionRepository opinionRepository;

    @PostMapping("/new")
    public ResponseEntity<Opinion> createOpinion(@RequestBody Opinion opinion){  //Valid?
        return ResponseEntity.ok(opinionService.addNewOpinion(opinion));
    }

    @GetMapping("/opinion")
    public ResponseEntity<?> getOpinion(Long Id){
        Opinion opinion = opinionService.getOpinion(Id);
        if (opinion == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(opinionService.getOpinion(Id));
    }
    @GetMapping("/list")
    public ResponseEntity<?> showAllOpinion(Contract contract) {
        Opinion opinion = opinionService.ShowAllOpinion(contract);
        return ResponseEntity.ok().body(opinionService.ShowAllOpinion(contract));
    }
}
