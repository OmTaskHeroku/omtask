package com.example.omtask.Controllers;

import com.example.omtask.Users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/meksyk")
    public ResponseEntity<String> printString() {
        return ResponseEntity.ok().body("Kapcie od babci");
    }
}