package com.users.controller;

public record CreateUserResponse(
        String firstName,
        String lastName,
        String email,
        String userId) {
}
