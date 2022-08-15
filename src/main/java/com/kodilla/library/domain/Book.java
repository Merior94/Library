package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity(name = "book")
public class Book {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name="id", unique=true)
    private long id;

    @ManyToOne
    private Title title;

    @Column(name = "status")
    private BookStatus status;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title=" + title +
                ", status=" + status +
                '}';
    }
}
