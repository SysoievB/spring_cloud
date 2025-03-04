package com.users;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = -2731425678149216053L;

    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false, length = 50)
    String firstName;

    @Column(nullable = false, length = 50)
    String lastName;

    @Column(nullable = false, length = 120, unique = true)
    String email;

    @Column(nullable = false, unique = true)
    String userId;

    @Column(nullable = false, unique = true)
    String encryptedPassword;

    public User(String firstName, String lastName, String email, String userId, String encryptedPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userId = userId;
        this.encryptedPassword = encryptedPassword;
    }
}
