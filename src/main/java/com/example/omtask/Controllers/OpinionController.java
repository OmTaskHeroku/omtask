package com.example.omtask.Controllers;

import com.example.omtask.Opinions.OpinionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OpinionController {

    private final OpinionService opinionService;
}
