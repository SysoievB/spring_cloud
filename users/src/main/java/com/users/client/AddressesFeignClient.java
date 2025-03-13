package com.users.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "address", path = "/address")
public interface AddressesFeignClient {

    @GetMapping("/{id}")
    @Retry(name = "address")
    @CircuitBreaker(name = "address", fallbackMethod = "getAddressFallback")
    Optional<AddressDto> getAddress(@PathVariable("id") Long id);

    default Optional<AddressDto> getAddressFallback(Long id, Throwable throwable) {
        System.out.println("ID=" + id + ", FALLBACK=" + throwable.getMessage());
        return Optional.empty();
    }
}
