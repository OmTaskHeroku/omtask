package com.example.omtask.Opinions;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OpinionService {

    private final OpinionRepository opinionRepository;
}
