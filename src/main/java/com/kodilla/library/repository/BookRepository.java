package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    List<Book> findAll();

    @Override
    Book save(Book book);

    @Override
    void deleteById(Long id);

    @Override
    Optional<Book> findById(Long id);

    Optional<List<Book>> findByAuthorContaining(String author);

    Optional<List<Book>> findByTitleContaining(String title);

    Optional<List<Book>> findByTitleContainingOrAuthorContaining(String title, String author);
}
