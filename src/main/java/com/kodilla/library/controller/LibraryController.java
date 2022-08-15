package com.kodilla.library.controller;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookDto;
import com.kodilla.library.mapper.BookDtoMapper;
import com.kodilla.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/library")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LibraryController {
    private final LibraryService service;
    //private final BookDtoMapper bookMapper;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = service.getAllBooks();
        return ResponseEntity.ok(books); //bookMapper.mapToBookDtoList(books)
    }

//    @GetMapping(value = "id/{bookId}")
//    public ResponseEntity<BookDto> getBookById(@PathVariable Long bookId) throws BookNotFoundException {
//        Book book = service.getBookById(bookId);
//        return ResponseEntity.ok(bookMapper.mapToBookDto(book));
//    }
//
//    @GetMapping(value = "title/{title}")
//    public ResponseEntity<List<BookDto>> getBookByTitle(@PathVariable String title) throws BookNotFoundException {
//        List<Book> books = service.getBookByTitle(title);
//        return ResponseEntity.ok(bookMapper.mapToBookDtoList(books));
//    }
//
//    @GetMapping(value = "author/{author}")
//    public ResponseEntity<List<BookDto>> getBookByAuthor(@PathVariable String author) throws BookNotFoundException {
//        List<Book> books = service.getBookByAuthor(author);
//        return ResponseEntity.ok(bookMapper.mapToBookDtoList(books));
//    }
//
//    @GetMapping(value = "titleorauthor/{query}")
//    public ResponseEntity<List<BookDto>> getBookByTitleOrAuthor(@PathVariable String query) throws BookNotFoundException {
//        List<Book> books = service.getBookByTitleOrAuthor(query);
//        return ResponseEntity.ok(bookMapper.mapToBookDtoList(books));
//    }
//
//    @PostMapping
//    public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto) {
//        Book book = bookMapper.mapToBook(bookDto);
//        service.saveBook(book);
//        return ResponseEntity.ok().build();
//    }
//
//    @PutMapping
//    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto){
//        Book book = bookMapper.mapToBook(bookDto);
//        Book savedBook = service.saveBook(book);
//        return ResponseEntity.ok(bookMapper.mapToBookDto(savedBook));
//    }
//
//    @DeleteMapping(value = "{id}")
//    public ResponseEntity<String> deleteBook(@PathVariable Long id){
//        service.deleteBook(id);
//        return ResponseEntity.ok("Book with id " + id + " deleted sucessfully");
//    }

}
