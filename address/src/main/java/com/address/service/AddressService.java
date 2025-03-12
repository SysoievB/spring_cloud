package com.address.service;

import com.address.controller.CreateAddressDto;
import com.address.controller.UpdateAddressDto;
import com.address.entity.Address;
import com.address.repository.AddressRepo;
import jakarta.annotation.PostConstruct;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepo repository;

    @PostConstruct
    public void init() {
        if (repository.count() == 0) {
            List<Address> addresses = List.of(
                    new Address(1L, "123 Main St", 45, "New York", "NY"),
                    new Address(2L, "456 Oak St", 12, "Los Angeles", "CA"),
                    new Address(3L, "789 Pine Ave", 8, "Chicago", "IL"),
                    new Address(4L, "321 Maple Rd", 99, "Houston", "TX"),
                    new Address(5L, "654 Cedar Ln", 25, "Phoenix", "AZ"),
                    new Address(6L, "987 Birch Blvd", 33, "San Francisco", "CA"),
                    new Address(7L, "741 Walnut Dr", 55, "Seattle", "WA"),
                    new Address(8L, "852 Elm St", 18, "Denver", "CO"),
                    new Address(9L, "963 Spruce Ct", 72, "Miami", "FL"),
                    new Address(10L, "159 Willow Way", 5, "Boston", "MA")
            );

            log.info("Initializing of Addresses: {} started", addresses);
            repository.saveAll(addresses);
            log.info("Initializing of Addresses finished...");
        }
    }

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
        val id = (long) findAllAddresses().size() + 1L;
        return repository.save(new Address(id, dto.street(), dto.number(), dto.city(), dto.state()));
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
