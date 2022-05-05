package com.example.omtask.Controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.omtask.Users.User;
import com.example.omtask.Users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/meksyk")
    public ResponseEntity<String> printString() {
        return ResponseEntity.ok().body("Kapcie od babci");
    }

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
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        userService.addRoleToUser(user.getUsername(), "ROLE_USER");
        return ResponseEntity.ok(user);
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