package com.example.omtask.Controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.omtask.Users.User;
import com.example.omtask.Users.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
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

    @GetMapping("/token_ref")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                User user = userService.getUserByUsername(username);
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName());
                String access_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", Collections.singletonList(user.getRole().getName()))
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);

                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);

            }catch(Exception exception){
                response.setHeader("error",exception.getMessage());
                response.setStatus(FORBIDDEN.value());
//                    response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        }else{
            throw new RuntimeException("Refresh token missing");
        }
    }
}