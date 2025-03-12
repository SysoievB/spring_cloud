package com.users.service;

import com.users.client.AddressesFeignClient;
import com.users.controller.CreateUserRequest;
import com.users.controller.CreateUserResponse;
import com.users.entity.User;
import com.users.repo.UsersRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AddressesFeignClient addressesFeignClient;

    public CreateUserResponse createUser(@NotNull CreateUserRequest request) {
        return Optional.ofNullable(request)
                .flatMap(req -> addressesFeignClient.getAddress(req.addressId())
                        .map(address -> {
                            val newUser = repository.save(
                                    new User(
                                            req.firstName(),
                                            req.lastName(),
                                            req.email(),
                                            UUID.randomUUID().toString(),
                                            passwordEncoder.encode(req.password()),
                                            address.id()
                                    )
                            );
                            return new CreateUserResponse(
                                    newUser.getFirstName(),
                                    newUser.getLastName(),
                                    newUser.getEmail(),
                                    newUser.getUserId(),
                                    address
                            );
                        })
                )
                .orElseThrow(() -> new RuntimeException("Error during creation occurred"));
    }


    public User authenticate(String email, String password) {
        return repository.findByEmail(email)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}
