package com.kodilla.library.mapper;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookDto;
import com.kodilla.library.domain.Title;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookDtoMapper {

    public Book mapToBook(final BookDto bookDto){
        return Book.builder()
                //.titleID(bookDto.getTitleID())
                .status(bookDto.getBookStatus())
                .build();
    }

    public Title mapToTitle(final BookDto bookDto){
        return Title.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .releaseDate((bookDto.getReleaseDate()))
                .build();
    }

//    public BookDto mapToBookDto(final Book book, final Title title){
//        return new BookDto(book.getId(), book.getTitleID().getTitle(), book.getTitleID().getAuthor());
//    };

//    public List<BookDto> mapToBookDtoList(final List<Book> bookList){
//        return bookList.stream()
//                .map(this::mapToBookDto)
//                .collect(Collectors.toList());
//    }

}
