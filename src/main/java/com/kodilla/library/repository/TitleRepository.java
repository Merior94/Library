package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TitleRepository extends CrudRepository<Title, Long> {

    @Override
    List<Title> findAll();

    @Override
    Title save(Title title);

    @Override
    void deleteById(Long id);

    @Override
    Optional<Title> findById(Long id);

    Optional<Title> findByTitle(String title);

    Optional<List<Title>> findByTitleContaining(String title);
}
