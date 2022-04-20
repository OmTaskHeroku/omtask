package com.example.omtask.Controllers;

import com.example.omtask.Messages.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;
}
