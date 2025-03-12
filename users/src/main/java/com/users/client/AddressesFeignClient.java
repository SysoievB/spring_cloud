package com.users.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Optional;

@FeignClient(name = "address", path = "/address")
public interface AddressesFeignClient {

    @GetMapping("/{id}")
    @CircuitBreaker(name = "address", fallbackMethod = "")
    Optional<AddressDto> getAddress(@PathVariable("id") Long id);

    default Optional<AddressDto> getAddressFallback(Long id, Throwable throwable) {
        return Optional.empty();
    }
}
