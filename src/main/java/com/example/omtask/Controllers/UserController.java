package com.example.omtask.Controllers;

import com.example.omtask.Users.User;
import com.example.omtask.Users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    
    @GetMapping("/{username}")
    public ResponseEntity<?> getUser(@PathVariable String username){
        User user = userService.getUserByUsername(username);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping()
    public ResponseEntity<?> getUserFromToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        User user = userService.getUserFromToken(token);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/url")
    public ResponseEntity<?> getUrl(){
        String url = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        return ResponseEntity.ok(url);
    }
}