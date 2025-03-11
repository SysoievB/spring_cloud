package com.address.controller;

import com.address.entity.Address;
import com.address.service.AddressService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService service;

    @GetMapping("/status/check")
    public String checkStatus() {
        return "Address works!!!";
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id) {
        return service.findAddressById(id);
    }

    @GetMapping
    public List<Address> findAll() {
        return service.findAllAddresses();
    }

    @PostMapping
    public Address save(@RequestBody @NotNull CreateAddressDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public Address update(
            @PathVariable Long id,
            @RequestBody @NotNull UpdateAddressDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @NotNull Long id) {
        service.delete(id);
    }
}
