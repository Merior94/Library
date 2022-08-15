package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Lease;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaseRepository extends CrudRepository<Lease, Long> {

    @Override
    List<Lease> findAll();

    @Override
    Lease save(Lease lease);

    @Override
    void deleteById(Long id);

//    @Override
//    Optional<Book> findById(Long id);
//
//    Optional<List<Book>> findByAuthorContaining(String author);
//
//    Optional<List<Book>> findByTitleContaining(String title);
//
//    Optional<List<Book>> findByTitleContainingOrAuthorContaining(String title, String author);
}