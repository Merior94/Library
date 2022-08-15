package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BookDto {
    private long titleID;
    private String title;
    private String author;
    private BookStatus bookStatus;
    private LocalDate releaseDate;
}
