package com.users.client;

public record AddressDto(
        Long id,
        String street,
        int number,
        String city
) {
}
