package com.address.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "addresses")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String street;
    int number;
    String city;
    String state;

    public Address(String street, int number, String city, String state) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
    }

    public Address update(String street, Integer number, String city, String state) {
        if (street != null && !street.isBlank()) {
            this.street = street;
        }
        if (number != null && number > 0) {
            this.number = number;
        }
        if (city != null && !city.isBlank()) {
            this.city = city;
        }
        if (state != null && !state.isBlank()) {
            this.state = state;
        }

        return this;
    }
}
