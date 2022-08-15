package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity(name = "title")
public class Title {

    @Id
    @NotNull
    @GeneratedValue
    @Column
    private long id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private LocalDate releaseDate;

    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "title",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Book> books;

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate=" + releaseDate +
                ", nrOfBooks=" + books.size() +
                '}';
    }
}
