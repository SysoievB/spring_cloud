package com.users.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "address", path = "/address")
public interface AddressesFeignClient {

    @GetMapping("/{id}")
    Optional<AddressDto> getAddress(@PathVariable("id") Long id);
}
