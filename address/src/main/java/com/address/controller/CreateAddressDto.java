package com.address.controller;

import jakarta.validation.constraints.NotNull;

public record CreateAddressDto(
        @NotNull String street,
        @NotNull Integer number,
        @NotNull String city,
        @NotNull String state
) {
}
