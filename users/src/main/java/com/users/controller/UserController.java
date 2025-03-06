package com.users.controller;

import com.users.security.LoginDto;
import com.users.service.UserService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Validated
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/status/check")
    public String status() {
        return "Works!!!";
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @NotNull CreateUserRequest request) {
        return Optional.of(service.createUser(request))
                .map(res -> ResponseEntity.status(HttpStatus.CREATED).body(res))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @NotNull LoginDto dto) {
        return Optional.of(service.authenticate(dto.email(), dto.password()))
                .map(user ->
                        ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(user.getFirstName() + " " + user.getLastName() + " logged in successfully!")
                )
                .orElseGet(() -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }
}
