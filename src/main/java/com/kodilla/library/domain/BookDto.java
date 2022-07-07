package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookDto {
    private long id;
    private String title;
    private String author;
}
