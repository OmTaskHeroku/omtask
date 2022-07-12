package com.example.omtask.Controllers;

import com.example.omtask.Contracts.Contract;
import com.example.omtask.Contracts.ContractStatus;
import com.example.omtask.Instances.Instance;
import com.example.omtask.Opinions.Opinion;
import com.example.omtask.Opinions.OpinionRepository;
import com.example.omtask.Opinions.OpinionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/opinions")
public class OpinionController {

    private final OpinionService opinionService;

    @PostMapping("/new")
    public ResponseEntity<Opinion> createOpinion(@RequestBody Opinion opinion){
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

    @GetMapping
    public ResponseEntity<?> showUserOpinions(String suspects_nick) {
        return ResponseEntity.ok().body(opinionService.ShowOpinionsForOneUser(suspects_nick));
    }

    @GetMapping("/list")
    public ResponseEntity<?> showAllOpinions() {
        return ResponseEntity.ok().body(opinionService.ShowAllOpinion());
    }
}
