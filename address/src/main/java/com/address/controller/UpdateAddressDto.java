package com.address.controller;

import jakarta.annotation.Nullable;

public record UpdateAddressDto(
        @Nullable String street,
        @Nullable Integer number,
        @Nullable String city,
        @Nullable String state
) {
}