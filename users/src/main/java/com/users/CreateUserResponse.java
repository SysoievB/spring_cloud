package com.users;

public record CreateUserResponse(
        String firstName,
        String lastName,
        String email,
        String userId) {
}
