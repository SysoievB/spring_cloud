package com.users;

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
    private final PasswordEncoder encoder;

    public CreateUserResponse createUser(@NotNull CreateUserRequest request) {
        return Optional.ofNullable(request)
                .map(req -> {
                    val newUser = repository.save(
                            new User(
                                    req.firstName(),
                                    req.lastName(),
                                    req.email(),
                                    UUID.randomUUID().toString(),
                                    encoder.encode(req.password())
                            )
                    );
                    return new CreateUserResponse(
                            newUser.getFirstName(),
                            newUser.getLastName(),
                            newUser.getEmail(),
                            newUser.getUserId()
                    );
                })
                .orElseThrow(() -> new RuntimeException("Smth bad happened!!!"));
    }
}
