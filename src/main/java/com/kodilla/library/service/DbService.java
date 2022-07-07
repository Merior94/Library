package com.kodilla.library.service;

import com.kodilla.library.controller.BookNotFoundException;
import com.kodilla.library.domain.Book;
import com.kodilla.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    private final BookRepository repository;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(final Long id) throws BookNotFoundException{
        return repository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    public List<Book> getBookByTitle(String title) throws BookNotFoundException{
        return repository.findByTitleContaining(title).orElseThrow(BookNotFoundException::new);
    }

    public List<Book> getBookByAuthor(String author) throws BookNotFoundException{
        return repository.findByAuthorContaining(author).orElseThrow(BookNotFoundException::new);
    }

    public List<Book> getBookByTitleOrAuthor(String query) throws BookNotFoundException{
        return repository.findByTitleContainingOrAuthorContaining(query, query).orElseThrow(BookNotFoundException::new);
    }

    public Book saveBook(final Book book){
        return repository.save(book);
    }

    public void deleteBook(final Long id){
        repository.deleteById(id);
    }

}
