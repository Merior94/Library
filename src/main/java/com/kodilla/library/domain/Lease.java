package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity(name = "lease")
public class Lease {

    @Id
    @NotNull
    @GeneratedValue
    @Column
    private long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn
    private Book book;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn
    private User user;

    @Column
    private LocalDate rentDate;

    @Column
    private LocalDate dueDate;

    @Override
    public String toString() {
        return "Lease{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                ", rentDate=" + rentDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
