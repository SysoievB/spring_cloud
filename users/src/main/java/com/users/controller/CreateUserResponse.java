package com.users.controller;

import com.users.client.AddressDto;

public record CreateUserResponse(
        String firstName,
        String lastName,
        String email,
        String userId,
        AddressDto dto) {
}
