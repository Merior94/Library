package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity(name = "user")
public class User {

    @Id
    @NotNull
    @GeneratedValue
    @Column
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private LocalDate joinDate;

    @Column
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", joinDate=" + joinDate +
                ", email='" + email + '\'' +
                '}';
    }
}
