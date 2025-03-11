package com.address.service;

import com.address.controller.CreateAddressDto;
import com.address.controller.UpdateAddressDto;
import com.address.entity.Address;
import com.address.repository.AddressRepo;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepo repository;

    public List<Address> findAddressByCity(String city) {
        return repository.findAddressByCity(city);
    }

    public List<Address> findAllAddresses() {
        return (List<Address>) repository.findAll();
    }

    public Address findAddressById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
    }

    public Address save(@NotNull CreateAddressDto dto) {
        return repository.save(new Address(dto.street(), dto.number(), dto.city(), dto.state()));
    }

    public Address update(@NotNull Long id, UpdateAddressDto dto) {
        return repository.findById(id)
                .map(address -> address.update(dto.street(), dto.number(), dto.city(), dto.state()))
                .orElseThrow(() -> new RuntimeException("Address not found"));
    }

    public void delete(Long id) {
        repository.findById(id)
                .ifPresentOrElse(
                        repository::delete,
                        () -> {
                            throw new RuntimeException("Address not found");
                        }
                );
    }
}
